/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voshodnerd.nine_gold_web_services.repository;
import com.voshodnerd.nine_gold_web_services.model.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Талалаев
 */
@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}

