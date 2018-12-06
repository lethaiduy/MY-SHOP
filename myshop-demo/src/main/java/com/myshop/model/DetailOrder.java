package com.myshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Detail_Order")
public class DetailOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="detailid")
	private int detailid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prodid")
	private Product product;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid")
	private Order order;
	@Column(name ="quantity")
	private int quantity;
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public DetailOrder() {
		super();
	}
	public DetailOrder(int detailid, Product product, Order order, int quantity) {
		super();
		this.detailid = detailid;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}
}
