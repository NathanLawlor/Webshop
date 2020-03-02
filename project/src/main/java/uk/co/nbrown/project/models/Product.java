package uk.co.nbrown.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PRODUCT_TABLE")
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	int id;
	@Column(name="PRODUCT_NAME")
	String name;
	@Column(name="PRODUCT_DESC")
	String description;
	@Column(name="PRODUCT_PRICE")
	double price;
	@Column(name="PRODUCT_IMG")
	String imgSource;
	
	public Product() {}

	public Product(String name, String description, double price, String imgSource) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgSource = imgSource;
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

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImgSource() {
		return imgSource;
	}

	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}

	@Override
	public String toString() {
		return ("ID: " + this.id + ", Name: " + this.name + ", Description: " + this.description + ", Price: £" + this.price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass()) { return false; }
		Product other = (Product) obj;
		
		if (this.getName() != other.getName()) { return false; }
		
		return this.id == other.id;	
	}
}
