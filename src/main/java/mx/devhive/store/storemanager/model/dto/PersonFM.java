package mx.devhive.store.storemanager.model.dto;

import javax.validation.constraints.NotEmpty;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class PersonFM {

	@Id
	private ObjectId _id;
	
	@NotEmpty(message = "message")
	@ApiModelProperty(required = true, example = "pedro@gmail.com")
	private String email;

	@ApiModelProperty(required = true, 
			value = "Nombre de la persona o razón social")
	private String razonSocial;

	@Indexed(unique = true, direction = IndexDirection.ASCENDING)
	@ApiModelProperty(required = true, value = "rfc del contribuyente")
	private String rfc;
	
}
