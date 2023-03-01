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
@Table(name="order_master")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="order_id")
  private int orderid;
  @Column(name="total_cost")
  private double totalcost;
  @OneToMany(cascade = CascadeType.ALL)
  private Set<Item> ob;
 
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public double getTotalcost() {
	return totalcost;
}
public void setTotalcost(double totalcost) {
	this.totalcost = totalcost;
}
  
}
