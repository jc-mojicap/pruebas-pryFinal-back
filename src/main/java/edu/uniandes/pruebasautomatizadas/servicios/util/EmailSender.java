package edu.uniandes.pruebasautomatizadas.servicios.util;

import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * Clase encargada de el envío de correos simples.
 * 
 * @author Chuidiang
 */
public class EmailSender {
    
    private static final Logger LOG = Logger.getLogger(EmailSender.class.getName());
    public static final String ESTADO_ENVIADO = "ENVIADO";
    public static final String ESTADO_NO_ENVIADO = "NO ENVIADO";
    private String servidorSMTP;
    private String cuenta;
    private String contrasena;
    private String destinatario;
    private String copiaOculta;
    private String con_copia;
    private String asunto;
    private String cuerpoMensaje;
    private Collection<DataSource> adjuntos;
    
    /**
     * Usar conexion ssl
     */
    private Boolean ssl = false;
  
    /**
     * Representa un sesion mail
     */
    private Session session; 
   
    /**
     * Conecta al servidor SMTP y envia el mail
     */
    private Transport t;
    
    /**
     * Propiedades del sistema
     */
    private Properties props; 
    
    /**
     * Puerto de salida
     */
    private Integer port;
    
    /**
     * Puerto de salida
     */
    private Boolean authUser; 
    
    /**
     * Representa un mensaje de e-mail
     */
    private Message message;
    
    private boolean isHtml = true;
    
    /**
     * Constructor, toma los parámetros de configuración a partir del archivo
     * app_props.properties
     */
    public EmailSender() {
        ResourceBundle rb = ResourceBundle.getBundle("resources/app_props");
        this.servidorSMTP = rb.getString("smtp.host");
        this.port = Integer.valueOf(rb.getString("smtp.port"));
        this.authUser = Boolean.valueOf(rb.getString("smtp.auth"));
        this.ssl = Boolean.valueOf(rb.getString("smtp.ssl"));
        this.cuenta = rb.getString("user.name");
        this.contrasena = rb.getString("user.pass");
    }
    
    /**
     * Constructor, se indica el servidor smtp, el nombre de usuario o cuenta y
     * la clave de ingreso
     * 
     * @param servidorSMTPHost
     * @param cuenta
     * @param contrasena
     */
    public EmailSender(String servidorSMTPHost, String cuenta, String contrasena) {
        this.servidorSMTP = servidorSMTPHost;
        this.cuenta = cuenta;
        this.contrasena = contrasena;
    }
    
    /**
     * Constructor, se indica el servidor smtp, el nombre de usuario o cuenta y
     * la clave de ingreso. Adicionalmente el puerto de conexión y si se
     * requiere una conexión segura SSL
     * 
     * @param servidorSMTPHost
     * @param cuenta
     * @param contrasena
     * @param puerto
     * @param ssl
     */
    public EmailSender(String servidorSMTPHost, String cuenta, String contrasena, Integer puerto, boolean ssl) {
        this.servidorSMTP = servidorSMTPHost;
        this.cuenta = cuenta;
        this.contrasena = contrasena;
        this.port = puerto;
        this.ssl = ssl;
    }
    
    /**
     * Constructor, se indica el servidor smtp, el nombre de usuario o cuenta y
     * la clave de ingreso. Adicionalmente el puerto de conexión y si se
     * requiere una conexión segura SSL
     * 
     * @param servidorSMTPHost
     * @param cuenta
     * @param contrasena
     * @param puerto
     * @param ssl
     * @param authUser
     */
    public EmailSender(String servidorSMTPHost, String cuenta, String contrasena, String puerto, String ssl, String authUser) {
        this.servidorSMTP = servidorSMTPHost;
        this.cuenta = cuenta;
        this.contrasena = contrasena;
        this.port = Integer.valueOf(puerto);
        this.ssl = Boolean.valueOf(ssl);
        this.authUser = Boolean.valueOf(authUser);
    }

	/**
     * Inicia la conexión con el servidor SMTP
     * 
     * @throws MessagingException
     */
    private void connect() throws MessagingException {
        try {
            
            props = System.getProperties();
            
            props.setProperty("mail.smtp.ssl.trust", "*");
            props.setProperty("mail.smtp.host", servidorSMTP);
            if (authUser != null) {
                props.setProperty("mail.smtp.auth", authUser.toString());
            }
            props.setProperty("mail.smtp.user", cuenta);
            props.setProperty("mail.smtp.quitwait", "false");
            
            props.setProperty("mail.smtp.starttls.enable", "true");
            
            props.setProperty("mail.smtps.host", servidorSMTP);
            props.setProperty("mail.smtps.auth", "true");
            
            props.put("mail.debug", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.socketFactory.port", "25");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "true");
            
            if (port != null) {
                props.setProperty("mail.smtp.port", port.toString());
                props.setProperty("mail.smtps.port", port.toString());
                props.put("mail.smtp.socketFactory.port", port.toString());
            }
            
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
            } catch (GeneralSecurityException e1) {
                e1.printStackTrace();
                LOG.log(Level.SEVERE, e1.getMessage(), e1);
            }
            props.put("mail.smtp.ssl.socketFactory", sf);
            
            /**
             * Obtener objeto Session
             */
            if (authUser != null && authUser) {
                Authenticator auth = new SMTPAuthenticator();
                session = Session.getInstance(props, auth);
            } else {
                session = Session.getInstance(props);
            }
            
            session.setDebug(false);
           
            /**
             * Conectar al servidor SMTP y enviar el mensaje
             */
            t = session.getTransport(ssl ? "smtps" : "smtp");
            
            t.connect(servidorSMTP, cuenta, contrasena);
        } catch (MessagingException me) {
            LOG.log(Level.SEVERE, me.getMessage(), me);
            throw me;
        }
    }
    
    /**
     * Cierra la conexión con el servidor SMTP
     * 
     * @throws MessagingException
     */
    private void close() throws MessagingException {
        try {
            if (t != null) {
                t.close();
            }
        } catch (MessagingException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    /**
     * Envía un mensaje de correo con los parámetros indicados
     * 
     * @param destinatario
     * @param asunto
     * @param cuerpoMensaje
     * @throws MessagingException
     */
    public void send(String destinatario, String asunto, String cuerpoMensaje) throws MessagingException {
        send(destinatario, null, null, asunto, cuerpoMensaje, null, true);
    }
    
    /**
     * Envía un mensaje de correo con los parámetros indicados
     * 
     * @param destinatario
     * @param asunto
     * @param cuerpoMensaje
     * @param adjuntos
     * @throws MessagingException
     */
    public void send(String destinatario, String asunto, String cuerpoMensaje, Collection<DataSource> adjuntos) throws MessagingException {
        send(destinatario, null, null, asunto, cuerpoMensaje, adjuntos, true);
    }
    
    /**
     * Envía un mensaje de correo con los parámetros indicados
     * 
     * @param destinatario
     * @param copia
     * @param copia_oculta
     * @param asunto
     * @param cuerpoMensaje
     * @param adjuntos
     * @param isHtml
     * @throws MessagingException
     */
    public void send(String destinatario, String copia, String copia_oculta, String asunto, String cuerpoMensaje, Collection<DataSource> adjuntos,
            boolean isHtml) throws MessagingException {
            this.send(destinatario, copia, copia_oculta, asunto, cuerpoMensaje, adjuntos, isHtml, null);
    }
    
    /**
     * Envía un mensaje de correo con los parámetros indicados
     * @param destinatario
     * @param copia
     * @param copiaOculta
     * @param asunto
     * @param cuerpoMensaje
     * @param adjuntos
     * @param isHtml
     * @param callback
     * @throws MessagingException
     */
    public void send(String destinatario, String copia, String copiaOculta, String asunto, String cuerpoMensaje, Collection<DataSource> adjuntos,
            boolean isHtml, final EmailCallback callback) throws MessagingException {
            
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.isHtml = isHtml;
        if (this.isHtml) {
            this.cuerpoMensaje = StringUtils.encodingToHTML(cuerpoMensaje);
        } else {
            this.cuerpoMensaje = cuerpoMensaje;
        }
        this.copiaOculta = copiaOculta;
        this.con_copia = copia;
        this.adjuntos = adjuntos;
        Thread run = new Thread() {
            
            @Override
            public void run() {
                try {
                    connect();
                    send();
                    if (callback != null) {
                        EmailSendResult result = new EmailSendResult();
                        result.setSended(true);
                        callback.excecute(result);
                    }
                } catch (MessagingException ex) {
                    LOG.log(Level.SEVERE, ex.getMessage(), ex);
                    if (callback != null) {
                        EmailSendResult result = new EmailSendResult();
                        result.setSended(false);
                        result.setException(ex);
                        callback.excecute(result);
                    }
                } finally {
                    try {
                        close();
                    } catch (MessagingException ex) {
                        LOG.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }
            }
        };
        run.start();
    }
    
    /**
     * Realiza el envio de email
     * @param destinatario Emails a los cuales va dirigido el mail
     * @param copia Emails a los cuales se les realizará copia
     * @param copiaOculta
     * @param asunto Asunto del email
     * @param cuerpoMensaje Texto del mensaje
     * @param adjuntos Archivos adjuntos al email
     * @param isHtml Si el cuerpo es visto como html
     * @throws MessagingException Excepcion lanzada
     */
	public void enviarEmail(String destinatario, String copia, String copiaOculta, String asunto, String cuerpoMensaje,
			Collection<DataSource> adjuntos, boolean isHtml) throws MessagingException {
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.isHtml = isHtml;

		if (this.isHtml) {
			this.cuerpoMensaje = StringUtils.encodingToHTML(cuerpoMensaje);
		} else {
			this.cuerpoMensaje = cuerpoMensaje;
		}

		this.copiaOculta = copiaOculta;
		this.con_copia = copia;
		this.adjuntos = adjuntos;

		connect();
		send();
	}
    
    /**
     * Envía un mensaje de correo con los parámetros precargados en la instancia
     * de esta clase
     * 
     * @throws MessagingException
     */
    private void send() throws MessagingException {
        
        if (t == null) {
            throw new MessagingException("Mail is not conected");
        }
        
        try {
            
            /**
             * Una MultiParte para agrupar texto e imagen.
             */
            MimeMultipart multiParte = new MimeMultipart();
            
            /**
             * Se compone la parte del texto
             */
            BodyPart texto = new MimeBodyPart();
            if (isHtml) {
                texto.setContent(cuerpoMensaje, "text/html");
            } else {
                texto.setText(cuerpoMensaje);
            }
            
            /**
             * Se agrega el texto a la MultiParte
             */
            multiParte.addBodyPart(texto);
            
            // Se agregan los objetos especificados en la lista de DataSources
            if (adjuntos != null) {
                for (DataSource archivoAdjunto : adjuntos) {
                    BodyPart adjunto = new MimeBodyPart();
                    adjunto.setDataHandler(new DataHandler(archivoAdjunto));
                    adjunto.setFileName(archivoAdjunto.getName());
                    multiParte.addBodyPart(adjunto);
                }
            }
            
            // Se compone el correo, dando to, from, subject y el contenido.
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(cuenta));
            
            Address[] addresesTo = InternetAddress.parse(this.destinatario, false);
            if (addresesTo != null) {
                for (Address address : addresesTo) {
                    message.addRecipient(Message.RecipientType.TO, address);
                }
            }
            
            if (copiaOculta != null && copiaOculta.length() > 0) {
                Address[] addreses = InternetAddress.parse(this.copiaOculta, false);
                if (addreses != null) {
                    for (Address address : addreses) {
                        message.addRecipient(Message.RecipientType.BCC, address);
                    }
                }
            }
            if (con_copia != null && con_copia.length() > 0) {
                Address[] addreses = InternetAddress.parse(this.con_copia, false);
                if (addreses != null) {
                    for (Address address : addreses) {
                        message.addRecipient(Message.RecipientType.CC, address);
                    }
                }
            }
            message.setSubject(asunto);
            message.setContent(multiParte);
            
            // Se envia el correo.
            t.sendMessage(message, message.getAllRecipients());
            
        } catch (MessagingException me) {
            LOG.log(Level.SEVERE, me.getMessage(), me);
            throw me;
        }
    }
    
    /**
     * Clase que permite la autenticación segura/doble si el servidor lo
     * requiere
     * 
     * @author jmaldonado
     */
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username = cuenta;
            String password = contrasena;
            return new PasswordAuthentication(username, password);
        }
    }
}
