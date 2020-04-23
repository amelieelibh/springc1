package mx.devhive.store.storemanager.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import mx.devhive.store.storemanager.model.dto.UserType;

@Data
@Builder
@Document(collection = "users")
public class User {

	@Id
	@NotNull(message = "el email es requerido")
	@NotEmpty(message = "el email es requerido")
	private String email;

	@NotNull(message = "el userName es requerido")
	@NotEmpty(message = "el userName es requerido")
	@Indexed(direction = IndexDirection.ASCENDING, unique = false)
	private String userName;

	@NotNull(message = "el pass es requerido")
	@NotEmpty(message = "el pass es requerido")
	private String pass;

	@NotNull(message = "el type es requerido")
	private UserType type;
	
}
