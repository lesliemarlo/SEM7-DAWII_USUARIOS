package pe.edu.cibertec.dawii.ms.usuarios.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.dawii.ms.usuarios.model.Usuario;
import pe.edu.cibertec.dawii.ms.usuarios.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> listaUsuarios() {
		return usuarioService.obtenerTodosUsuarios();
	}

	//busuqeda por id y email
@GetMapping("/{id}")
public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
	Optional<Usuario> usuario =  usuarioService.obtenerUsuarioPorId(id);
	return usuario
			.map(ResponseEntity::ok)//200 en caso de encontrar
			.orElseGet(() -> ResponseEntity.notFound().build()); //404 si no existe
	
}

@GetMapping("/filtros/email/")
public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@RequestParam String email){
	Optional<Usuario> usuario =  usuarioService.obtenerUsuarioPorEmail(email);
	return usuario
			.map(ResponseEntity::ok)//200 en caso de encontrar
			.orElseGet(() -> ResponseEntity.notFound().build()); //404 si no existe
	
}

//ingresra un nuevo rgeistro
@PostMapping
public Usuario crearUsuario(@RequestBody Usuario usuario) {
	return usuarioService.crearUsuario(usuario);
}

//actualizar
@PutMapping("/{id}")
public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
	Optional<Usuario> usuarioActualizado =  usuarioService.actualizarUsuario(usuario,id);
	return usuarioActualizado
			.map(ResponseEntity::ok)//200 en caso de encontrar
			.orElseGet(() -> ResponseEntity.notFound().build()); //404 si no existe
	
}

//eliminar
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
	usuarioService.eliminarUsuario(id);
	return ResponseEntity.noContent().build();
}

}
