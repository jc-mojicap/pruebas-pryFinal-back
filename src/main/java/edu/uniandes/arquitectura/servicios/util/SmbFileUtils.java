package edu.uniandes.arquitectura.servicios.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public final class SmbFileUtils {

    private static final int BUFFER_SIZE = 1024 * 1024;
    
   /**
    * Copia un archivo al directorio que viene por parametro
    * @param archivoCopiar Flujo de bytes del archivo a copiar
    * @param rutaDestino Ruta donde se copiara el archivo
    * @param nombreArchivo Nombre del archivo
    * @param direccion Ip del servidor donde se copiara el archivo
    * @param usuario Usuario para acceder al directorio compartido
    * @param contrasena Contrasena para acceder al directorio compartido
    * @throws IOException Excepcion controlada
    */
    public static void copiarAdjunto(InputStream archivoCopiar, String rutaDestino, String nombreArchivo, 
    		String direccion, String usuario, String contrasena) throws IOException {
        
    	StringBuilder odesFile = new StringBuilder("smb:");
        odesFile.append(rutaDestino);
        NtlmPasswordAuthentication oNtlmPasswordAuthentication = new NtlmPasswordAuthentication(direccion, usuario, contrasena);
        SmbFile oSmbFileDes = new SmbFile(odesFile.toString(), oNtlmPasswordAuthentication);
        
        if (!oSmbFileDes.exists()) {
            oSmbFileDes.mkdirs();
        }
        
        StringBuilder oStringBuilder = new StringBuilder();
        oStringBuilder.append(oSmbFileDes.getPath());
        oStringBuilder.append("/");
        oStringBuilder.append(nombreArchivo);
        
        SmbFile oSmbFileSrc = new SmbFile(oStringBuilder.toString(), oNtlmPasswordAuthentication);
        jcifs.smb.SmbFileOutputStream out = new SmbFileOutputStream(oSmbFileSrc);
        
        byte[] buf = new byte[BUFFER_SIZE];
        int len;
        
        try {
            while ((len = archivoCopiar.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } finally {
        	archivoCopiar.close();
            out.close();
        }
    }
    
    /**
     * Obtiene el flujo de bytes del archivo
     * @param nombreArchivo Nombre del archivo
     * @param direccion Ip del servidor donde se copiara el archivo
     * @param usuario Usuario para acceder al directorio compartido
     * @param contrasena Contrasena para acceder al directorio compartido
     * @throws IOException Excepcion controlada
     */
    public static byte[] obtenerBytesAdjunto(String nombreArchivo, String direccion, String usuario, String contrasena) throws FileNotFoundException, IOException {
        StringBuilder oSrcFile = new StringBuilder();
        oSrcFile.append("smb:");
        oSrcFile.append(nombreArchivo);
        NtlmPasswordAuthentication oNtlmPasswordAuthentication = new NtlmPasswordAuthentication(direccion, usuario, contrasena);
        SmbFile oSmbFileSrc = new SmbFile(oSrcFile.toString(), oNtlmPasswordAuthentication);
        
        if (!oSmbFileSrc.exists()) {
        	throw new FileNotFoundException("El archivo no existe");
        }
        
        InputStream in = null;
        ByteArrayOutputStream baos = null;
        
        try {
            in = new BufferedInputStream(oSmbFileSrc.getInputStream(), BUFFER_SIZE);
            baos = new ByteArrayOutputStream();
            int read;
            
            byte[] buffer = new byte[BUFFER_SIZE];
            
            while ((read = in.read(buffer)) > -1) {
                baos.write(buffer, 0, read);
            }
            
            return baos.toByteArray();
        } finally {
            if (in != null) {
                in.close();
            }
            if (baos != null) {
                baos.close();
            }
        }
    }
}
