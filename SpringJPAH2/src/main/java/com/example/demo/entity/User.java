package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "USER_INFO")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer id;
	private String name;
	
	@Min(100)
	@Max(1000)
	private Integer salary;
	
	private String teamName;

	
	public User(String name, @Min(100) @Max(1000) Integer salary, String teamName) {
		super();
		this.name = name;
		this.salary = salary;
		this.teamName = teamName;
	}
	public String getName() {
		return name;
	}
	public User() {
		super();
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}

	
	public Integer getId() {
		return id;
	}
	
	public Integer getSalary() {
		return salary;
	}
	public User setSalary(Integer salary) {
		this.salary = salary;
		return this;
	}
	public String getTeamName() {
		return teamName;
	}
	public User setTeamName(String teamName) {
		this.teamName = teamName;
		return this;
	}
	
	
}
