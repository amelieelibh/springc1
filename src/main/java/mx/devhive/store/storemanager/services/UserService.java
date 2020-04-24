package mx.devhive.store.storemanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.devhive.store.storemanager.model.User;
import mx.devhive.store.storemanager.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public User findUserByEmail(String email){
		return userRepository.findByEmail(email);
	}

	@Transactional
	public User saveUser(User user){
		return userRepository.save(user);
	}


	public boolean deleteUserByEmail(String email){
		User user = userRepository.findByEmail(email);
		if(user != null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}
}
