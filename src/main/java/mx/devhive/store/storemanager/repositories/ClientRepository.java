package mx.devhive.store.storemanager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.devhive.store.storemanager.model.Client;


public interface ClientRepository extends MongoRepository<Client, String> {

	Client findByEmail(String email);
	
	void deleteByEmail(String email);
	
	Client findByRfc(String rfc);

	void deleteByRfc(String rfc);
}
