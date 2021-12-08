package de.htwberlin.webtech.webtech.persistence;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "buckets")
public class BucketEntity {
    private static final String SEQ_NAME = "bucket_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "id")
    private long id;
    @OneToOne
    @JoinColumn(name = "users_id")
    private UserEntity user;
    @ManyToMany
    @JoinTable(name = "buckets_products",
            joinColumns = @JoinColumn(name = "bucket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;

}