package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_contact")
public class UserContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	private Integer phoneNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id", referencedColumnName = "id")
	private User user;
	
	public User getUser() {
		return user;
	}
	public UserContact setUser(User user) {
		this.user = user;
		return this;
	}
	public Integer getId() {
		return id;
	}
	public UserContact setId(Integer id) {
		this.id = id;
		return this;
	}
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public UserContact setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}
	
	
}
