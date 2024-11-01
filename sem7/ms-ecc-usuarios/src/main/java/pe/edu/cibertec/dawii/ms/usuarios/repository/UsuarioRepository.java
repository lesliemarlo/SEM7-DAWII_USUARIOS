package pe.edu.cibertec.dawii.ms.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.dawii.ms.usuarios.model.Usuario;

//----
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByEmail(String email);
	
}
