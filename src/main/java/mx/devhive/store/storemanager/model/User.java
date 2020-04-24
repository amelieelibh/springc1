package mx.devhive.store.storemanager.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import mx.devhive.store.storemanager.model.dto.UserType;

@Data
@Builder
@Document(collection = "users")
public class User {

	@Id
	@ApiModelProperty(value = "Campo que guarda el email del usuario", position = 0)
	@NotNull(message = "el email es requerido")
	@NotEmpty(message = "el email es requerido")
	private String email;

	@ApiModelProperty(value = "Campo que el nombre del usuario", position = 1)
	@NotNull(message = "el userName es requerido")
	@NotEmpty(message = "el userName es requerido")
	@Indexed(direction = IndexDirection.ASCENDING, unique = false)
	private String userName;

	@ApiModelProperty(hidden = true)
	@NotNull(message = "el pass es requerido")
	@NotEmpty(message = "el pass es requerido")
	private String pass;

	@ApiModelProperty(value = "Campo que indica el tipo del usuario", position = 2)
	@NotNull(message = "el type es requerido")
	private UserType type;
	
}
