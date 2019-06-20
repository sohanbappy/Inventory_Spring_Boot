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
@Table(name="item_tb")
public class Item {
	
	
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
	@Column(name="cat_id")
	private String cat_id;
	@Column(name="quantity")
	private String quantity;
	@Column(name="price")
	private String price;
	@Column(name="creation_date")
	private Date creation_date;
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", cat_id=" + cat_id + ", quantity=" + quantity + ", price="
				+ price + ", creation_date=" + creation_date + "]";
	}
	public Item(int id, String name, String cat_id, String quantity, String price, Date creation_date) {
		super();
		this.id = id;
		this.name = name;
		this.cat_id = cat_id;
		this.quantity = quantity;
		this.price = price;
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
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public Item() {
		super();
	}
	
	

}
