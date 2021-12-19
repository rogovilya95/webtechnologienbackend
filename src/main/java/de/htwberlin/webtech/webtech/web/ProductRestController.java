package de.htwberlin.webtech.webtech.web;
import de.htwberlin.webtech.webtech.service.ProductService;
import de.htwberlin.webtech.webtech.web.api.Products;
import de.htwberlin.webtech.webtech.web.api.ProductManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(path = "/api/v1/products")
    public ResponseEntity<List<Products>> Products() {return ResponseEntity.ok(productService.findAll());}


    @GetMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Products> ProductsById(@PathVariable Long id) {
        var product = productService.findById(id);
        return product != null? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductManipulationRequest request) throws URISyntaxException {
        var product = productService.create(request);
        URI uri = new URI("/api/v1/product/" + product.getProductId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody ProductManipulationRequest request) {
        var product = productService.update(id, request);
        return product != null? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean successful = productService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
