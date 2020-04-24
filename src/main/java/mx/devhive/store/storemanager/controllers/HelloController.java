package mx.devhive.store.storemanager.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello", produces = {"application/json"})
//	@RequestMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String greet() {
		return "{'msg':'hello rest world'}";
	}
	
	@RequestMapping(value = "/helloWithName/{name}", 
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public String greetWithName(
			@PathVariable(value = "name", required = true) String name) {
		return "{'msg':'hello " + name + " from rest world'}";
	}
}
