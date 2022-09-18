package com.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springProject.entity.Role_user;
@Repository
public interface Role_Repository extends JpaRepository<Role_user, Long>{
Role_user findByName(String name);
}
