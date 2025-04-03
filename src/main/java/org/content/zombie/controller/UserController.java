package org.content.zombie.controller;


import org.content.zombie.entity.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    // FLUX MONO

    @GetMapping("/list")
    public Flux<User> getAllUsers() { return Flux.fromIterable(users); }

    @PostMapping("/create-user")
    public Mono<User> createUser(@RequestBody User user){
        users.add(user);
        return Mono.just(user);
    }

    @DeleteMapping("/delete")  // /?id=1
    public Mono<String> deleteUser(int id){
        users.removeIf(user-> user.getId() == id);
        return Mono.just("user deleted");
    }
}
