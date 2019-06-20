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
@Table(name="sell_tb")
public class Sell {
	
	
	public Sell() {
		super();
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInv_no() {
		return inv_no;
	}
	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
	@Override
	public String toString() {
		return "Sell [id=" + id + ", inv_no=" + inv_no + ", name=" + name + ", item_id=" + item_id + ", quantity="
				+ quantity + ", sub_total=" + sub_total + ", creation_date=" + creation_date + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public double getSub_total() {
		return sub_total;
	}


	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}


	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
    generator="native")
	@GenericGenerator(
	name = "native",
	strategy = "native"
	)
	@Column(name="id")
	private int id;
	
	@Column(name="inv_no")
	private String inv_no;
	@Column(name="name")
	private String name;
	@Column(name="item_id")
	private String item_id;
	@Column(name="quantity")
	private String quantity;
	@Column(name="sub_total")
	private double sub_total;
	@Column(name="creation_date")
	private Date creation_date;


	
	

}
