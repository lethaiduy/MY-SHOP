package com.dxc.entity;

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
@Table(name = "detailorder")
public class DetailOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "detailid")
	private int detailid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid")
	private Order order;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prodid")
	private Product product;
	@Column(name = "quantity")
	private int quantity;

	public int getDetailid() {
		return detailid;
	}

	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}

	public DetailOrder() {
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
