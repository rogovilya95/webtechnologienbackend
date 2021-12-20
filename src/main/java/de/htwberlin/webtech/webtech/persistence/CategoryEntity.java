package de.htwberlin.webtech.webtech.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categories")
public class CategoryEntity {
    private static final String SEQ_NAME = "category_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToOne(mappedBy = "category", fetch = FetchType.EAGER)
    private ProductEntity product;

//    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
//    private List<ProductEntity> products;

    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    protected CategoryEntity() {}

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}

