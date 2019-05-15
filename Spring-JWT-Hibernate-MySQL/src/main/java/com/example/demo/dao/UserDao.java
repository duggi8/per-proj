package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDao {

	@Autowired
	EntityManagerFactory emf;

	/*CriteriaQuery<String> q = cb.createQuery(String.class);
	Root<Order> order = q.from(Order.class);
	q.select(order.get("shippingAddress").<String>get("state"));
	
	CriteriaQuery<Product> q2 = cb.createQuery(Product.class);
	q2.select(q2.from(Order.class)
	            .join("items")
	            .<Item,Product>join("product"));*/
	
	public List<User> getUserDetails() {
		Session session = emf.unwrap(SessionFactory.class).openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> contactRoot = criteria.from(User.class);
		criteria.select(contactRoot);
		return session.createQuery(criteria).getResultList();
		
	}
	
	
	public List<User> createUsers(List<User> users){
		Session session = emf.unwrap(SessionFactory.class).openSession();
		session.beginTransaction();
		for(User user:users) {
			session.save(user);
		}
		session.getTransaction().commit();
		session.close();
		return users;
	}
		
		
		
	
}
