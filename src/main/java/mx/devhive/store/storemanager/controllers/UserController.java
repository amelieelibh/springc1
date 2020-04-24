package mx.devhive.store.storemanager.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
import mx.devhive.store.storemanager.model.User;
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

	@ApiOperation(value = "Método que busca todos los usuarios de la base de datos", 
			responseContainer = "List", response = User.class)
	@GetMapping(value = "/", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping(value = "/{email:.+}")
	public ResponseEntity<User> getUser(@PathVariable(value = "email") String email){
		return ResponseEntity.ok(userService.findUserByEmail(email));
	}

	@ApiOperation(value = "Método que permite guardar un usuario", response = User.class,
			httpMethod = "POST", code = 202, 
			responseHeaders = {@ResponseHeader(name = "useremail", response = String.class)})
	@PostMapping(value = "/", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveUser(@RequestBody(required = true) @Valid @NotNull User user){
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED.value())
					.body(userService.saveUser(user));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("useremail", user.getEmail()).build();
		}
	}


	@DeleteMapping(value = "/{email:.+}")
	public boolean deleteUser(@PathVariable(value = "email") String email){
		return userService.deleteUserByEmail(email);
	}

}
