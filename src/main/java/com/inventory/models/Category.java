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
@Table(name="category_tb")
public class Category {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
		             generator="native")
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
		)
	@Column(name="id")
	private int id;
	
	@Column(name="name",length=250,nullable=false)
	private String name;
	
	@Column(name="org_id",length=250,nullable=false)
	private String org_id;
	
	
	
	@Column(name="creation_date")
	private Date creation_date;
	
	


	public Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrg_id() {
		return org_id;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", org_id=" + org_id + ", creation_date=" + creation_date
				+ "]";
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}



	public Category(String name, String org_id, Date creationDate) {
		super();
		this.name = name;
		this.org_id = org_id;
		this.creation_date = creationDate;
	}

}
