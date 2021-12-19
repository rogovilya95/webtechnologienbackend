package de.htwberlin.webtech.webtech.web.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CategoryManipulationRequest {

    public CategoryManipulationRequest() {
    }

    public String categoryName;

    public CategoryManipulationRequest(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
