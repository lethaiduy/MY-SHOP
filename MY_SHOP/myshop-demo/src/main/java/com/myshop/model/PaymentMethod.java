package com.myshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Method_payment")
public class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "methodid")
	private int methodid;
	@Column(name = "methodname")
	private String methodname;
	public int getMethodid() {
		return methodid;
	}
	public void setMethodid(int methodid) {
		this.methodid = methodid;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public PaymentMethod() {
		super();
	}
	
	

}
