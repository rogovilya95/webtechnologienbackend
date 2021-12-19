package de.htwberlin.webtech.webtech.web;
import de.htwberlin.webtech.webtech.service.CategoryService;
import de.htwberlin.webtech.webtech.web.api.Category;
import de.htwberlin.webtech.webtech.web.api.CategoryManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(path = "/api/v1/category")
    public ResponseEntity<List<Category>> categories() {return ResponseEntity.ok(categoryService.findAll());}


    @GetMapping(path = "/api/v1/category/{id}")
    public ResponseEntity<Category> categoriesByID(@PathVariable Long id) {
        var category = categoryService.findById(id);
        return category != null? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/category")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryManipulationRequest request) throws URISyntaxException {
        var category = categoryService.create(request);
        URI uri = new URI("/api/v1/category/" + category.getCategoryId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(path = "/api/v1/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody CategoryManipulationRequest request) {
        var category = categoryService.update(id, request);
        return category != null? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean successful = categoryService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
