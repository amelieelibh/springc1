package mx.devhive.store.storemanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.devhive.store.storemanager.model.Provider;
import mx.devhive.store.storemanager.repositories.ProviderRepository;

@Slf4j
@Service
public class ProviderService {

	@Autowired
	private ProviderRepository providerRepository;
	
	public List<Provider> getAllProviders(){
		return providerRepository.findAll();
	}

	public Provider findByAccount(String account){
		return providerRepository.findByAccount(account);
	}
	
	public Provider findProviderByEmail(String email){
		return providerRepository.findByEmail(email);
	}

	public Provider saveProvider(Provider provider){
		return providerRepository.save(provider);
	}


	public boolean deleteProviderByEmail(String email){
		try {
			providerRepository.deleteByEmail(email);
			return true;
		}catch (Exception e) {
			log.error("No se pudo Borrar el proveedor con el email: " 
					+ email, e);
		}
		return false;
	}
	
	public boolean deleteProviderByRfc(String rfc){
		try {
			providerRepository.deleteByRfc(rfc);
			return true;
		}catch (Exception e) {
			log.error("No se pudo Borrar el proveedor con el RFC: " 
					+ rfc, e);
		}
		return false;
	}
}
