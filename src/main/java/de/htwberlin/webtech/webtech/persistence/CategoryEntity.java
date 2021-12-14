package de.htwberlin.webtech.webtech.persistence;

import javax.persistence.*;

@Entity(name = "categories")
public class CategoryEntity {
    private static final String SEQ_NAME = "category_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "category_id")
    private long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;


    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;

    }

    protected CategoryEntity() {}

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
