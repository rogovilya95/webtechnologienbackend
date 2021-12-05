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
    @Column(name = "id")
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Products_categories",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;

    public ProductEntity(long id, String productName, String productDescription, BigDecimal productPrice, List<CategoryEntity> categories) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.categories = categories;
    }

    public ProductEntity(String productName, String productDescription) {

    }

    public ProductEntity() {

    }

    public ProductEntity(String productName, String productDescription, BigDecimal productPrice) {

    }

    public long getId() {
        return id;
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

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
