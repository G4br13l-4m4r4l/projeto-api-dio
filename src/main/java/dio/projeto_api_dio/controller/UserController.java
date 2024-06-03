package dio.projeto_api_dio.controller;

import dio.projeto_api_dio.model.User;
import dio.projeto_api_dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        var userCreated = userService.create(user);
        return ResponseEntity.ok().body(userCreated);
    }

}
