package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Alien;

@Repository
public interface AlienRepo extends CrudRepository<Alien, Integer>{

}
