/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voshodnerd.nine_gold_web_services.repository;
import com.voshodnerd.nine_gold_web_services.model.UserRoles;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Талалаев
 */
public interface TypeuserRepository extends CrudRepository<UserRoles, Long> {
    UserRoles findByName(String role);
}

