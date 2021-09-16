package cake.tz.services.impl;

import cake.tz.constant.ProductImplConstant;
import cake.tz.dtos.ProductDTO;
import cake.tz.exception.domain.ProductNotFoundException;
import cake.tz.models.Product;
import cake.tz.repositories.ProductRepository;
import cake.tz.services.ProductService;
import org.apache.commons.lang3.StringUtils;
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
    public ProductDTO findById(long id) throws ProductNotFoundException {
        Product product = productRepository.getById(id);
        if (product == null) {
            throw new ProductNotFoundException(ProductImplConstant.NO_PRODUCT_FOUND_BY_ID);
        }
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    @Override
    public void create(ProductDTO productDTO) {
        Product product = new Product();
        // todo: add validate check
        if (StringUtils.isBlank(productDTO.getName())) {

        }

        product.setName(productDTO.getName());
        product.setModel(productDTO.getModel());
        product.setIngredients(productDTO.getIngredients());
        product.setDescription(productDTO.getDescription());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setReleasedDate(productDTO.getReleasedDate());

        productRepository.save(product);
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productRepository.getById(productDTO.getId());
        //todo: add validate check

        product.setName(productDTO.getName());
        product.setModel(productDTO.getModel());
        product.setIngredients(productDTO.getIngredients());
        product.setDescription(productDTO.getDescription());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setReleasedDate(productDTO.getReleasedDate());

        productRepository.save(product);
    }

}
