package mx.devhive.store.storemanager.model;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.devhive.store.storemanager.model.dto.PersonFM;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection = "providers")
public class Provider extends PersonFM{
	
	@ApiModelProperty(required = true, value = "Cuenta de depósito")
	private String account;
	
}
