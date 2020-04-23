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

import mx.devhive.store.storemanager.model.Provider;
import mx.devhive.store.storemanager.services.ProviderService;

@Controller
@RequestMapping("/providers")
public class ProviderController {


	@Autowired
	private ProviderService providerService;

	@GetMapping(value = "/")
	public List<Provider> getAllProviders(){
		return providerService.getAllProviders();
	}

	@GetMapping(value = "/{email:.+}")
	public Provider getProvider(
			@PathVariable(value = "email") String email){
		return providerService.findProviderByEmail(email);
	}

	@PostMapping(value = "/")
	public Provider saveProvider(
			@RequestBody(required = true) @Valid 
			@NotNull Provider provider){
		return providerService.saveProvider(provider);
	}


	@DeleteMapping(value = "/{email:.+}")
	public boolean deleteProvider(
			@PathVariable(value = "email") String email){
		return providerService.deleteProviderByEmail(email);
	}
	
}
