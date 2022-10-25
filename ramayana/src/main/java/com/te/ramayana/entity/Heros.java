package com.te.ramayana.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Heros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String name;
	private String power;
	private String designation;
	private String kingdom;
	private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getKingdom() {
		return kingdom;
	}
	public void setKingdom(String kingdom) {
		this.kingdom = kingdom;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Heros() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Heros(int id, String name, String power, String designation, String kingdom, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.designation = designation;
		this.kingdom = kingdom;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Heros [id=" + id + ", name=" + name + ", power=" + power + ", designation=" + designation + ", Kingdom="
				+ kingdom + ", gender=" + gender + "]";
	}
	
	

}
