package mx.devhive.store.storemanager.services;

import org.springframework.stereotype.Service;

@Service
public class ProductoSevice {
	
	public String info;
	
	public String comprar() {
		
		info = "Producto comprado"; 
		  
		return info;
	}	
	
	public String Vender() {
		
		info = "Producto comprado";
		
		info = "Producto vendido";
		
		return info;
	}
	

}
