package fr.morandini.APISample.controller;

import fr.morandini.APISample.entity.User;
import fr.morandini.APISample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserRestController {

    private final UserService service;

    @Autowired
    public UserRestController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<User> getAllUser() {
        return service.findAll();
    }

    @GetMapping(value = "/resttemplateexample", produces = "application/json")
    public List<User> restTemplateExample() {
        return Arrays.asList(new RestTemplate().getForEntity("http://localhost:8080/user/", User[].class).getBody());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User getUser(@PathVariable long id) {
        return service.findOne(id).get();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
        User user = service.findOne(userId).get();
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        final User updatedUser = service.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = getUser(userId);
        service.deleteUser(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

