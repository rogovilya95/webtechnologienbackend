package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.BucketEntity;
import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.repository.BucketRepository;
import de.htwberlin.webtech.webtech.repository.ProductRepository;
import de.htwberlin.webtech.webtech.repository.UserRepository;
import de.htwberlin.webtech.webtech.web.api.Bucket;
import de.htwberlin.webtech.webtech.web.api.BucketManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BucketService {

    private final BucketRepository bucketRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public BucketService(BucketRepository bucketRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.bucketRepository = bucketRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<Bucket> findAll() {
        List<BucketEntity> categories = bucketRepository.findAll();
        return categories.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Bucket findByProductId(Long id) {
        var bucketEntity = bucketRepository.findById(id);
        return bucketEntity.map(this::transformEntity).orElse(null);
    }

    public Bucket transformEntity(BucketEntity bucketEntity) {
        var productIds = bucketEntity.getProducts().stream().map(ProductEntity::getProductId).collect(Collectors.toList());
        return new Bucket(
                bucketEntity.getBucketId(),
                bucketEntity.getUser().getUserId(),
                productIds
                );
    }

    public Bucket createBucket(BucketManipulationRequest request) {
        var user = userRepository.findById(request.getUserId()).orElseThrow();
        var bucketEntity = new BucketEntity(user, null);
        bucketEntity = bucketRepository.save(bucketEntity);
        return transformEntity(bucketEntity);
    }

    public void addProducts(BucketManipulationRequest request) {
        var bucketEntity = bucketRepository.findById(request.getUserId());
        var newProductIds = new ArrayList<ProductEntity>();

    }

//    public void addProducts(BucketManipulationRequest request){
//        var user = userRepository.findById(request.getUserId()).orElseThrow();
//        var productIds = request.getProductIds().stream().map(ProductEntity::getProductId).collect(Collectors.toList());
//        var bucketEntity = new BucketEntity(user, productIds);
//        List<ProductEntity> newProductList = productIds == null? new ArrayList<>() : new ArrayList<ProductEntity>(bucketEntity.getProducts());
//        newProductList.addAll(getCollectRefProductsByIds(productIds));
//        request.setProductIds(newProductList);
//        bucketRepository.save(bucketEntity);
//    }
//    public Bucket createBucket(UserEntity user, List<Long> productsIds) {
//        var bucketEntity = new BucketEntity();
//        bucketEntity.setUser(user);
//        List<ProductEntity> productList = getCollectRefProductsByIds(productsIds);
//        bucketEntity = bucketRepository.save(bucketEntity);
//        return transformEntity(bucketEntity);
//
//
//    }



}
