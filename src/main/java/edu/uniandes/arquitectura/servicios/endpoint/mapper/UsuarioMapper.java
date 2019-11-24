package edu.uniandes.arquitectura.servicios.endpoint.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.uniandes.arquitectura.servicios.dao.model.Usuario;
import edu.uniandes.arquitectura.servicios.endpoint.dto.UsuarioDTO;

/**
 * Interfaz que permite hacer mapeo entre objetos Usuario y UsuarioDto
 * @author JuanMojica
 *
 */
//@Mapper
public interface UsuarioMapper {

	/**
     * Instancia de la clase.
     */
//	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	/**
	 * Tranforma un UsuarioDto en un Usuario.
	 * @param UsuarioDTO Objeto a transformar.
	 * @return Objeto transformado.
	 */
//	Usuario usuarioDtoToUsuario(UsuarioDTO usuarioDto);
	
	/**
	 * Transforma un Usuario en un UsuarioDto.
	 * @param Objeto a transformar.
	 * @return Objeto transformado.
	 */
//	UsuarioDTO usuarioToUsuarioDto(Usuario usuario);
	
	/**
	 * Tranforma una List&lt;UsuarioDto&gt; en una List&lt;Usuario&gt;
	 * @param usuariosDto Lista de objetos a transformar.
	 * @return Lista de objetos transformados.
	 */
//	List<Usuario> usuariosDtoToUsuarios(List<UsuarioDTO> usuariosDto);
	
	/**
	 * Tranforma una List&lt;Usuario&gt; en una List&lt;UsuarioDto&gt;
	 * @param usuarios Lista de objetos a transformar.
	 * @return Lista de objetos transformados.
	 */
//	List<UsuarioDTO> usuariosToUsuariosDto(List<Usuario> usuarios);
	
}
