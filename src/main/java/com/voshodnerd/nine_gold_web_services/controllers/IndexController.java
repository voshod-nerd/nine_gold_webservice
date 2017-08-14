/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voshodnerd.nine_gold_web_services.controllers;

import com.voshodnerd.nine_gold_web_services.model.User;
import com.voshodnerd.nine_gold_web_services.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ПК
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {
        String name = "Hi";
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        System.out.println("1 step");
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getLastName());
        System.out.println(user.getPassword());
       
        user.setActive(Boolean.TRUE);
        user.setUserId(Integer.SIZE);
         System.out.println(user.getUserId());
        System.out.println(user.getActive());
        
        

        ModelAndView modelAndView = new ModelAndView();
        User userExists=null;
        try {
        userExists = userService.findUserByEmail(user.getEmail());
        } catch (Exception error) {
            System.out.println(error.fillInStackTrace());
        } 
        System.out.println("2 step");
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

}
