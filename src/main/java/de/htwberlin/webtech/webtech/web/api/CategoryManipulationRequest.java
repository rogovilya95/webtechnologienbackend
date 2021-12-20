package de.htwberlin.webtech.webtech.web.api;



public class CategoryManipulationRequest {

    public String categoryName;

    public CategoryManipulationRequest(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryManipulationRequest() {}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
