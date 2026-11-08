package com.coder_prathamesh.graphql_demo.controller;

import com.coder_prathamesh.graphql_demo.entities.User;
import com.coder_prathamesh.graphql_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //create user api:
    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone,
                           @Argument String email, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    //getAllUsers api:
    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //get user by id api:
    @QueryMapping
    public User getUserById(@Argument Long user_id) {
        return userService.getUser(user_id);
    }

    /*//update user api:
    @MutationMapping
    public User updateUser(@Argument Long id, @Argument String name, @Argument String phone,
                           @Argument String email, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.updateUser(user);
    }*/

    //delete user api:
    @MutationMapping
    public Boolean deleteUser(@Argument Long user_id) {
        return userService.deleteUser(user_id);
    }
}
