package com.coder_prathamesh.graphql_demo.service;

import com.coder_prathamesh.graphql_demo.entities.User;
import com.coder_prathamesh.graphql_demo.helper.ExceptionHandler;
import com.coder_prathamesh.graphql_demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    //create user
    public User createUser(User user) {
        return userRepo.save(user);
    }

    //get single user
    public User getUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(ExceptionHandler::throwResourceNotFoundException);
    }

    //get all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //update user
    public User updateUser(Long id, User user) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());
        return userRepo.save(existingUser);
    }

    //delete user
    public Boolean deleteUser(Long id) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        userRepo.delete(existingUser);
        return true;
    }
}
