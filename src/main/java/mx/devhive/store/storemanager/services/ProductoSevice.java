package mx.devhive.store.storemanager.services;

import org.springframework.stereotype.Service;

@Service
public class ProductoSevice {
	
	public String info;
	
	public String comprar(String sku) {
		
		info = "Producto comprado: " + sku; 
		  
		return info;
	}	
	
	public String vender(String sku) {
		info = "Producto vendido: " + sku;
		
		return info;
	}
	

}
