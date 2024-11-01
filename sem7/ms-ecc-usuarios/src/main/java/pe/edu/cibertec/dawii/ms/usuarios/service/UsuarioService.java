package pe.edu.cibertec.dawii.ms.usuarios.service;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.dawii.ms.usuarios.model.Usuario;

public interface UsuarioService {
	List<Usuario> obtenerTodosUsuarios();
	Optional<Usuario> obtenerUsuarioPorId(Long idUsuario);
	Optional<Usuario> obtenerUsuarioPorEmail(String email);
	Usuario crearUsuario(Usuario usuario);
	Optional<Usuario> actualizarUsuario(Usuario usuario, Long idUsuario);
	void eliminarUsuario(Long idUsuario);

}
