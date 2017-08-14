/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voshodnerd.nine_gold_web_services.repository;

/**
 *
 * @author Талалаев
 */
import com.voshodnerd.nine_gold_web_services.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository("userRepository")
public interface UserRepository  extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}