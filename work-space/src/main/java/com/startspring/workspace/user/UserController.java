package com.startspring.workspace.user;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private int counter = 0;

    @GetMapping("")
    public List<User> allUsers(@RequestParam(required = false) String birthYear) {
        if (birthYear != null) {
            List<User> birthYearUsers = new ArrayList<>();
            for (User user :
                    users) {
                if (user.getBirthYear() == Integer.parseInt(birthYear)) {
                    birthYearUsers.add(user);
                }
            }
            return birthYearUsers;
        }
        return users;
    }

    @GetMapping("/{id}")
    public User userWithId(@PathVariable int id) {
        for (User user :
                users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @PostMapping("")
    public User addUser(@RequestBody User user) {
        user.setId(counter++);
        users.add(user);
        return user;
    }

    @PutMapping("/{id}")
    private User updateUser(@RequestBody User user, @PathVariable int id) {
        for (User updateUser :
                users) {
            if (updateUser.getId() == id) {
                updateUser.setLogin(user.getLogin());
                updateUser.setName(user.getName());
                updateUser.setBirthYear(user.getBirthYear());
                updateUser.setPassword(user.getPassword());
            }
            return updateUser;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    private User deleteUser(@PathVariable int id) {
        for (User deleteUser : users) {
            if (deleteUser.getId() == id) {
                return users.remove(id);
            }
        }
        return null;
    }
}
