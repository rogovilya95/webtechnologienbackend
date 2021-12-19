package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.BucketEntity;
import de.htwberlin.webtech.webtech.persistence.CategoryEntity;
import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.web.api.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface BucketRepository extends JpaRepository<BucketEntity, Long> {
//        List<BucketEntity> findByBucketId(Long bucketId);
//        List<BucketEntity> findByProductsId(Long productId);
//        List<BucketEntity> findByUserId(Long userId);


}
