package com.myshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ProdGrp")
public class ProductGrp {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prodgrpid")
	private int prodgrpid;
	@Column(name = "prodgrpname")
	private String prodgrpname;
	
	public int getProdgrpid() {
		return prodgrpid;
	}
	public void setProdgrpid(int prodgrpid) {
		this.prodgrpid = prodgrpid;
	}
	public String getProdgrpname() {
		return prodgrpname;
	}
	public void setProdgrpname(String prodgrpname) {
		this.prodgrpname = prodgrpname;
	}
	
	public ProductGrp() {
		super();
	}
	public ProductGrp(int prodgrpid, String prodgrpname) {
		super();
		this.prodgrpid = prodgrpid;
		this.prodgrpname = prodgrpname;
	}
	
	
	

	
}
