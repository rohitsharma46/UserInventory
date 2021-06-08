package com.example.webform.service;

import com.example.webform.model.User;
import com.example.webform.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public User getUser(int id){return userRepo.findById(id).orElseThrow(); }

    public String updateUser(int id, User user){
        User oldUser = getUser(id);
        oldUser.setFName(user.getFName());
        oldUser.setLName(user.getLName());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        userRepo.save(oldUser);

        return "User Details Updated ";
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
