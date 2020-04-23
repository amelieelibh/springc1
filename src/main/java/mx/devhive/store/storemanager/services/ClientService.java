package mx.devhive.store.storemanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.devhive.store.storemanager.model.Client;
import mx.devhive.store.storemanager.repositories.ClientRepository;

@Slf4j
@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}

	public Client findClientByEmail(String email){
		return clientRepository.findByEmail(email);
	}

	public Client saveClient(Client client){
		return clientRepository.save(client);
	}


	public boolean deleteClientByEmail(String email){
		try {
			clientRepository.deleteByEmail(email);
			return true;
		}catch (Exception e) {
			log.error("No se pudo Borrar el proveedor con el email: " + email, e);
		}
		return false;
	}
	
	public boolean deleteClientByRfc(String rfc){
		try {
			clientRepository.deleteByRfc(rfc);
			return true;
		}catch (Exception e) {
			log.error("No se pudo Borrar el proveedor con el rfc: " + rfc, e);
		}
		return false;
	}
}
