package cake.tz.services.impl;

import cake.tz.dtos.ProductDTO;
import cake.tz.models.Product;
import cake.tz.repositories.ProductRepository;
import cake.tz.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductDTO findById(long id) {
        Product product = productRepository.getById(id);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    @Override
    public void create(ProductDTO productDTO) {
        Product product = new Product();
        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }
        if (productDTO.getModel() != null) {
            product.setModel(productDTO.getModel());
        }
        if (productDTO.getIngredients() != null) {
            product.setIngredients(productDTO.getIngredients());
        }
        if (productDTO.getDescription() != null) {
            product.setDescription(productDTO.getDescription());
        }
        if (productDTO.getPurchasePrice() != null) {
            product.setPurchasePrice(productDTO.getPurchasePrice());
        }
        if (productDTO.getReleasedDate() != null) {
            product.setReleasedDate(productDTO.getReleasedDate());
        }
        productRepository.save(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productRepository.getById(productDTO.getId());
        if (productDTO.getName() != null && productDTO.getName() !="") {
            product.setName(productDTO.getName());
        }
        if (productDTO.getModel() != null && productDTO.getModel() !="") {
            product.setModel(productDTO.getModel());
        }
        if (productDTO.getIngredients() != null) {
            product.setIngredients(productDTO.getIngredients());
        }
        if (productDTO.getDescription() != null) {
            product.setDescription(productDTO.getDescription());
        }
        if (productDTO.getPurchasePrice() != null) {
            product.setPurchasePrice(productDTO.getPurchasePrice());
        }
        if (productDTO.getReleasedDate() != null) {
            product.setReleasedDate(productDTO.getReleasedDate());
        }
        productRepository.save(product);
    }

}
