package de.htwberlin.webtech.webtech.web;
import de.htwberlin.webtech.webtech.service.UserService;
import de.htwberlin.webtech.webtech.web.api.User;
import de.htwberlin.webtech.webtech.web.api.UserManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> getUsers() {return ResponseEntity.ok(userService.findAll());}


    @GetMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        var person = userService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/users")
    public ResponseEntity<Void> createPerson(@RequestBody UserManipulationRequest request) throws URISyntaxException {
        var person = userService.create(request);
        URI uri = new URI("/api/v1/users/" + person.getUserId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<User> updatePerson(@PathVariable Long id, @RequestBody UserManipulationRequest request) {
        var person = userService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean successful = userService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
