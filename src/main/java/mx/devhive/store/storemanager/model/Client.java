package mx.devhive.store.storemanager.model;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.devhive.store.storemanager.model.dto.CardInfo;
import mx.devhive.store.storemanager.model.dto.PersonFM;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
//@CompoundIndexes({
//	@CompoundIndex(name = "rfc", unique = true, def = "{'rfc': 1}")
//})
@Document(collection = "clients")
public class Client extends PersonFM{

	@ApiModelProperty(required = true, value = "Dirección")
	private String address;
	
	@ApiModelProperty(required = true, value = "Información de la tarjeta")
	private CardInfo cardInfo;
	
}
