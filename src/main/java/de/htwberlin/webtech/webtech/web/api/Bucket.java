package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.UserEntity;

import java.util.List;

public class Bucket {
    private Long bucketId;
    private Long userId;
    private List<Long> productIds;

    public Bucket(Long bucketId, Long userId, List<Long> productIds) {
        this.bucketId = bucketId;
        this.userId = userId;
        this.productIds = productIds;
    }

    public Bucket() {
    }


    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
