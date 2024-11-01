package pe.edu.cibertec.dawii.ms.notificaciones.models;

import jakarta.persistence.Column;
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
public class Notificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	@Column(length = 100) 
	private String asunto;
	
	@Column(length = 200) 
	private String descripcion;
	
	@Column(length = 1) 
	private String tipoNotificacion;
	
	@Column(length = 50) 
	private String email;
}
