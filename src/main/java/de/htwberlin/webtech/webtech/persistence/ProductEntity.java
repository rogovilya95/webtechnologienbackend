package de.htwberlin.webtech.webtech.persistence;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "products")
public class ProductEntity {

    private static final String SEQ_NAME = "product_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<BucketEntity> buckets;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private CategoryEntity category;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "products_categories",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private List<CategoryEntity> categories;


    //public ProductEntity(String productName, String productDescription, BigDecimal productPrice, List<BucketEntity> buckets, CategoryEntity category) {
    public ProductEntity(String productName, String productDescription, BigDecimal productPrice, CategoryEntity category) {

        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.category = category;
    }

    protected ProductEntity() {
    }

    public long getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public List<BucketEntity> getBuckets() {
        return buckets;
    }

    public void setBuckets(List<BucketEntity> buckets) {
        this.buckets = buckets;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
