/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voshodnerd.nine_gold_web_services.service;

import com.voshodnerd.nine_gold_web_services.model.Role;

import com.voshodnerd.nine_gold_web_services.model.User;
import com.voshodnerd.nine_gold_web_services.repository.UserRepository;
import com.voshodnerd.nine_gold_web_services.service.UserService;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.voshodnerd.nine_gold_web_services.repository.RoleRepository;

/**
 *
 * @author Талалаев
 */
@Service("userService")
public class UserReposoryImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByRole("ADMIN");
        //user.setUserRolesCollection(userRole);
        userRepository.save(user);
    }

}
