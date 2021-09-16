package cake.tz.controllers;

import cake.tz.dtos.ProductDTO;
import cake.tz.exception.domain.ProductNotFoundException;
import cake.tz.models.Product;
import cake.tz.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/cakes")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> list() {
		return productService.findAll();
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ProductDTO productDTO) {
		productService.create(productDTO);
	}

	@PostMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody ProductDTO productDTO) {
		productService.update(productDTO);
	}

	@GetMapping("/{id}")
	public ProductDTO get(@PathVariable("id") long id) throws ProductNotFoundException {
		return productService.findById(id);
	}

}
