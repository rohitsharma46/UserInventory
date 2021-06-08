package com.example.webform.controller;


import com.example.webform.model.User;
import com.example.webform.repo.UserRepo;
import com.example.webform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is controller
@Controller
public class ControllerForm {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    public ControllerForm(UserRepo userRepo){
        this.userRepo=userRepo;
    }

//Add
//Requesting Add User Page
    @GetMapping("/form")
    public String addUserPage(@ModelAttribute(value = "user") User user){
        System.out.println("Requesting add user page");
        return "AddUser";
    }

//Adding User
    @RequestMapping(value = "/AddUser", method=RequestMethod.POST)
    public String addUser(User user) {
        System.out.println("Trying to Add User ");
        userService.save(user);
        System.out.println("User Added");
        return "redirect:/listallusers";
    }

//Display All Users
    @RequestMapping(value="/listallusers",method =RequestMethod.GET)
    public String listallusers(Model model){
        List<User> userlist = userService.getAllUsers();
        model.addAttribute("userlist",userlist);
        return "listallusers";
    }

//Edit User Page
    @RequestMapping(value="/updateUserPage/{id}",method =RequestMethod.GET)
    public String editUser(@PathVariable("id") int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "EditUser";
    }

// Edit User
    @RequestMapping(value = "/updateuser/{id}",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute (value="user")User user){
        System.out.println("Update User Request received ");
        int id = user.getId();
        userService.updateUser(id,user);
        return "redirect:/listallusers";
    }

//Delete User Page
    @RequestMapping(value="/deleteUserPage/{id}",method =RequestMethod.GET)
    public String deleteUserPage(@PathVariable("id") int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "deleteUser";
    }

    // Delete User
    @RequestMapping(value = "/deleteuser/{id}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id){
        System.out.println("Delete User Request received ");
        userService.deleteUser(id);
        return "redirect:/listallusers";
    }

//For Test
    @GetMapping("/success")
    public String webpage(){
        return "success";
    }



}
