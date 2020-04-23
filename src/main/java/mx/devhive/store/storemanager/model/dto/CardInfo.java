package mx.devhive.store.storemanager.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CardInfo {

	private String number;
	private String cvv;
	private String name;
	private String expirationMonth;
	private String expirationYear;
	
}
