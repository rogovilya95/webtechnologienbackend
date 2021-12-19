package de.htwberlin.webtech.webtech.persistence;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "buckets")
public class BucketEntity {
    private static final String SEQ_NAME = "bucket_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "bucket_id")
    private long bucketId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;


    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "buckets_products",
            joinColumns = @JoinColumn(name = "bucket_id", referencedColumnName = "bucket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"))
    private List<ProductEntity> products;

    public BucketEntity(UserEntity user, List<ProductEntity> productIds) {
        this.user = user;
        this.products = productIds;
    }

    public BucketEntity() {}

    public long getBucketId() {
        return bucketId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
