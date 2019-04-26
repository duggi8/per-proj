package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl {
  
	@Autowired
	EntityManagerFactory emf;
	
	void testCustomQuery(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query a = em.createNativeQuery("SELECT a.teamName, a.name FROM USER_INFO A");
		List<Object> users = a.getResultList();
		users.forEach(p->System.out.println(p));
		em.getTransaction().commit();
		em.close();
	}
}
