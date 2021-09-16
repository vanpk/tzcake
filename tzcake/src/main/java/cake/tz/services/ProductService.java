package cake.tz.services;

import cake.tz.dtos.ProductDTO;
import cake.tz.exception.domain.ProductNotFoundException;
import cake.tz.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAll();

    ProductDTO findById(long id) throws ProductNotFoundException;

    void create(ProductDTO productDTO);

    void update(ProductDTO productDTO);
}
