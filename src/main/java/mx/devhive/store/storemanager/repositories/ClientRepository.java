package mx.devhive.store.storemanager.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import mx.devhive.store.storemanager.model.Client;


public interface ClientRepository extends MongoRepository<Client, String> {

	Client findByEmail(String email);
	
	void deleteByEmail(String email);
	
	Client findByRfc(String rfc);

	void deleteByRfc(String rfc);

	@Query(value = "{}", sort = "{rfc: -1}")
	//@Query(value = "{rfc:'?0'}", sort = "{rfc: -1}")
	List<Client> findAllOrderByRfc();
}
