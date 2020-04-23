package mx.devhive.store.storemanager.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import mx.devhive.store.storemanager.model.User;
import mx.devhive.store.storemanager.model.dto.UserType;
import mx.devhive.store.storemanager.services.UserService;

// http://host-ip:port/context/users/metodo-accion/{var1}/{var2}/

//tipos de componentes
//@Component
//@Repository
//@Service
//@Controller
//@RestController

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping(value = "/{email:.+}")
	public User getUser(@PathVariable(value = "email") String email){
		return userService.findUserByEmail(email);
	}

	@PostMapping(value = "/")
	public User saveUser(@RequestBody(required = true) @Valid @NotNull User user){
		return userService.saveUser(user);
	}


	@DeleteMapping(value = "/{email:.+}")
	public boolean deleteUser(@PathVariable(value = "email") String email){
		return userService.deleteUserByEmail(email);
	}

}
