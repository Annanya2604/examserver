package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Role;



// to perform database operations
public interface RoleRepository  extends JpaRepository<Role,Long>{

}
