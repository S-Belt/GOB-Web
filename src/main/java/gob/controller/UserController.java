package gob.controller;

import gob.modele.User;
import gob.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Pour indiquer à Spring de considérer cette classe comme un controller
@RequestMapping("/user") // URL de notre API
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.creer(user);
    }
    @GetMapping("/read")
    public List<User> read(){
        return userService.lire();
    }
    @DeleteMapping("/delete/{user_id}")
    public String delete(@PathVariable String user_id){
        return userService.supprimer(user_id);
    }
    @PutMapping("/update/{user_id}")
    public User update(@PathVariable String user_id, @RequestBody User user){
        return userService.modifier(user_id, user);
    }
}
