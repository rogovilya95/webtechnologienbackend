package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.repository.CategoryRepository;
import de.htwberlin.webtech.webtech.repository.ProductRepository;
import de.htwberlin.webtech.webtech.web.api.Products;
import de.htwberlin.webtech.webtech.web.api.ProductManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    //private final UserService userService;
   // private final BucketService bucketService;
    private final CategoryRepository categoryRepository;
    //private final CategoryService categoryService;


    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        //this.userService = userService;
        //this.bucketService = bucketService;
        this.categoryRepository = categoryRepository;
        //this.categoryService = categoryService;
    }

    public List<Products> findAll() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }


    public Products findById(Long id) {
        var productEntity = productRepository.findById(id);
        return productEntity.map(this::transformEntity).orElse(null);
    }


    public Products create(ProductManipulationRequest request) {
        var category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
        var productEntity = new ProductEntity(request.getProductName(), request.getProductDescription(), request.getProductPrice(), category);
        productRepository.save(productEntity);
        return transformEntity(productEntity);
    }


    public Products update(Long id, ProductManipulationRequest request) {
        var productEntityOptional = productRepository.findById(id);
        if (productEntityOptional.isEmpty()) {
            return null;
        }
        var productEntity = productEntityOptional.get();
        productEntity.setProductName(request.getProductName());
        return transformEntity(productEntity);
    }


    public boolean deleteById(Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }


    private Products transformEntity(ProductEntity productEntity) {
        return new Products(
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductDescription(),
                productEntity.getProductPrice(),
                productEntity.getCategory().getCategoryId()
        );
    }
}
