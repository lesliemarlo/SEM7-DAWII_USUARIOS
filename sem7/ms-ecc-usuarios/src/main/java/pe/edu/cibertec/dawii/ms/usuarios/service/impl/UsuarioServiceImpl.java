package pe.edu.cibertec.dawii.ms.usuarios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ms.usuarios.model.Usuario;
import pe.edu.cibertec.dawii.ms.usuarios.repository.UsuarioRepository;
import pe.edu.cibertec.dawii.ms.usuarios.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> obtenerTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> obtenerUsuarioPorId(Long idUsuario) {
		return usuarioRepository.findById(idUsuario);
	}

	@Override
	public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);

	}

	// actualizacion
	@Override
	public Optional<Usuario> actualizarUsuario(Usuario usuario, Long idUsuario) {
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(idUsuario);
		return usuarioEncontrado.map(usuarioExistente -> {
			usuarioExistente.setNombre(usuario.getNombre());
			usuarioExistente.setEmail(usuario.getEmail());
			return usuarioRepository.save(usuarioExistente);
		});
		

	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		/*
		 * Optional<Usuario> usuarioEliminar = usuarioRepository.findById(idUsuario);
		 * if(usuarioEliminar.isPresent()) {
		 * usuarioRepository.delete(usuarioEliminar.get()); }
		 */
		usuarioRepository.deleteById(idUsuario);

	}

}
