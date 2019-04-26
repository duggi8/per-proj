package com.example.demo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserContact;

public interface UserContactRepo extends JpaRepository<UserContact, Integer> {


}
