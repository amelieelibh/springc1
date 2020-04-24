package mx.devhive.store.storemanager.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.devhive.store.storemanager.model.Client;
import mx.devhive.store.storemanager.services.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {


	@Autowired
	private ClientService clientService;

	@GetMapping(value = "/")
	public List<Client> getAllClients(){
		return clientService.getAllClients();
	}

	@GetMapping(value = "/{email:.+}")
	public Client getClient(@PathVariable(value = "email") String email){
		return clientService.findClientByEmail(email);
	}

	@PostMapping(value = "/")
	public Client saveClient(@RequestBody(required = true) @Valid @NotNull Client client){
		return clientService.saveClient(client);
	}


	@DeleteMapping(value = "/{email:.+}")
	public boolean deleteClient(@PathVariable(value = "email") String email){
		return clientService.deleteClientByEmail(email);
	}
	
	@GetMapping(value = "/orderByRfcDesc")
	public List<Client> getAllOrderByRfcDesc(){
		return null; // clientService.findByRfcDesc();
	}
	
	
}
