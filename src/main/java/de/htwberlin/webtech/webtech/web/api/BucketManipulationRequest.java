package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.UserEntity;

import java.util.List;
import java.util.Optional;

public class BucketManipulationRequest {

    private Long userId;
    private List<ProductEntity> productIds;


    public BucketManipulationRequest(Long userId, List<ProductEntity> productIds) {
        this.userId = userId;
        this.productIds = productIds;
    }

    public BucketManipulationRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductEntity> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<ProductEntity> productIds) {
        this.productIds = productIds;
    }
}
