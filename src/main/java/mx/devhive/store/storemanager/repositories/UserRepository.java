package mx.devhive.store.storemanager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.devhive.store.storemanager.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	// ?0
	User findByEmail(String email);
	
}
