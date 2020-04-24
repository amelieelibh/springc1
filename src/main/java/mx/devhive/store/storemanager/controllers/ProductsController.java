package mx.devhive.store.storemanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.devhive.store.storemanager.services.ProductoSevice;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductoSevice productService;

	@PutMapping(value = "/buy/{productKey}")
	public String buy(@PathVariable(value = "productKey") String id) {
		return productService.comprar(id);
	}
	

	@PutMapping(value = "/sell/{productKey}")
	public String sell(@PathVariable(value = "productKey") String id) {
		return productService.vender(id);
	}
}
