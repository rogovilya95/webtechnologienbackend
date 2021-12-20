package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.CategoryEntity;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

public class Products {
    public long productId;
    public String productName;
    public String productDescription;
    public BigDecimal productPrice;
    private Long categoryId;

    public Products(long productId, String productName, String productDescription, BigDecimal productPrice, Long categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
    }

    public Products() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
