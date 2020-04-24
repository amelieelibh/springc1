package mx.devhive.store.storemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {

//	@Autowired
//	private ProductService productService;

	@PutMapping(value = "/buy/{productKey}")
	public String buy(@PathVariable(value = "productKey") String id) {
		return null; // productService.buy(id);
	}
	

	@PutMapping(value = "/sell/{productKey}")
	public String sell(@PathVariable(value = "productKey") String id) {
		return null; // productService.sell(id);
	}
}
