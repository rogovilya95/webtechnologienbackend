package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.BucketEntity;
import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.repository.ProductRepository;
import de.htwberlin.webtech.webtech.web.api.Bucket;
import de.htwberlin.webtech.webtech.web.api.Products;
import de.htwberlin.webtech.webtech.web.api.ProductManipulationRequest;
import de.htwberlin.webtech.webtech.web.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;
    private final BucketService bucketService;


    public ProductService(ProductRepository productRepository, UserService userService, BucketService bucketService) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.bucketService = bucketService;
    }



//    public void addToUserBucket(Long productId, Long id) {
//
//        if(user == null) {
//            throw new RuntimeException("User not found" + id);
//        }
//        BucketEntity bucket = user.getBucket();
//        if(bucket==null) {
//            var newBucket = bucketService.createBucket(, Collections.singletonList(productId));
//            user.setBucket();
//            userService.save(bucket);
//        } else {
//            bucketService.addProducts(bucket, Collections.singletonList(productId));
//        }
//
//    }

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
        var productEntity = new ProductEntity(request.getProductName(), request.getProductDescription(), request.getProductPrice(), request.getCategories());
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
                productEntity.getCategories()
        );
    }
}
