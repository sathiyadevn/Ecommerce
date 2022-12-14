package com.revature.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="lpu_product_kart")
public class Cart {
	
	@Id
	@Column(name="cart_product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  cartProductId;
	
	
	@Column(name="cart_status")   // adding new column
	private int  cartStatus;
	
	@ManyToOne								
	@JoinColumn(name="product_id", referencedColumnName = "product_id")
	private Product product = new Product();
	
	@ManyToOne
	@JoinColumn(name="order_id", referencedColumnName = "order_id", nullable = true)
	private ProductOrder order = null;
	
	@ManyToOne
	@JoinColumn(name="email", referencedColumnName = "email")
	private UserEntity user = new UserEntity();
	
	public long getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductOrder getOrder() {
		return order;
	}
	public void setOrder(ProductOrder order) {
		this.order = order;
	}
	public int getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(int cartStatus) {
		this.cartStatus = cartStatus;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	

}
