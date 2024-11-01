package pe.edu.cibertec.dawii.ms.usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity                //marcar a la clase comouna entidad JPA
@Data                 //set y get + toString
@NoArgsConstructor    // agegar un constrctor sin parametros
@AllArgsConstructor    // agregar un constructor con parametros
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // ndica que sera autogenrado el campo
	private Long id;
	private String nombre;
	private String email;
	private String password;

}
