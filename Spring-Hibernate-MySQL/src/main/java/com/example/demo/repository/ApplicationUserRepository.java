package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{

	ApplicationUser findByUserName(String username);
}
