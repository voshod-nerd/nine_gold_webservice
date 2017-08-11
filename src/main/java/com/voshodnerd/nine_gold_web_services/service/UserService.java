/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voshodnerd.nine_gold_web_services.service;

import com.voshodnerd.nine_gold_web_services.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Талалаев
 */

public interface UserService {
    public User findUserByEmail(String email);
	public void saveUser(User user);
}
