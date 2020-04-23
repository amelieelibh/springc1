package mx.devhive.store.storemanager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.devhive.store.storemanager.model.Provider;


public interface ProviderRepository 
	extends MongoRepository<Provider, String> {

	Provider findByEmail(String email);
	
	void deleteByEmail(String email);
	
	Provider findByRfc(String rfc);
	
	void deleteByRfc(String rfc);
}
