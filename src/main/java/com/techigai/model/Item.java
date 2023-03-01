package com.techigai.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="item_master")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	  private int id;
	@Column(name="item_name")
	  private String name;
	@Column(name="item_desc")
	  private String desc;
	@Column(name="item_price")
	  private double price;
	@Column(name="item_status")
	private String status;
	@Column(name="qnty_in")
	private int QntyIn;
	
	@Column(name="qnty_out")
	private int QntyOut;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getQntyIn() {
		return QntyIn;
	}
	public void setQntyIn(int qntyIn) {
		QntyIn = qntyIn;
	}
	public int getQntyOut() {
		return QntyOut;
	}
	public void setQntyOut(int qntyOut) {
		QntyOut = qntyOut;
	}
	public int getAvlQnty() {
		return avlQnty;
	}
	public void setAvlQnty(int avlQnty) {
		this.avlQnty = avlQnty;
	}
	@Column(name="avl_qnty")
	private int avlQnty;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
 
}
