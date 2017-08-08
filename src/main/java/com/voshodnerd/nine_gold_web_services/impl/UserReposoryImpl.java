/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voshodnerd.nine_gold_web_services.impl;

import com.voshodnerd.nine_gold_web_services.model.Users;
import com.voshodnerd.nine_gold_web_services.repository.TypeuserRepository;
import com.voshodnerd.nine_gold_web_services.repository.UserRepository;
import com.voshodnerd.nine_gold_web_services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Талалаев
 */
@Service("userService")
public class UserReposoryImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TypeuserRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Users user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       
        Typeuser userRole = roleRepository.findByName("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
    }

}
