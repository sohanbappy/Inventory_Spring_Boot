package com.inventory.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="org_tb")
public class Organization {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
    generator="native")
	@GenericGenerator(
	name = "native",
	strategy = "native"
	)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="phone")
	private String phone;
	@Column(name="address")
	private String address;
	@Column(name="uname")
	private String uname;
	@Column(name="pass")
	private String pass;
	@Column(name="creation_date")
	private Date creation_date;
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", uname="
				+ uname + ", pass=" + pass + ", creation_date=" + creation_date + "]";
	}
	public Organization() {
		super();
	}
	public Organization(int id, String name, String phone, String address, String uname, String pass,
			Date creation_date) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.uname = uname;
		this.pass = pass;
		this.creation_date = creation_date;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	

}
