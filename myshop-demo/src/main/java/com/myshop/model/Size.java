package com.myshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Size")
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sizeid")
	private int sizeid;
	@Column(name = "sizename")
	private String sizename;
/*	@ManyToMany(cascade = {CascadeType.REMOVE})
	@JoinTable(name="Prod_Size",joinColumns = { @JoinColumn(name = "sizeid") },
            inverseJoinColumns = { @JoinColumn(name = "prodid") })*/
	@ManyToMany(fetch = FetchType.LAZY,
	        cascade =
	        {
	                CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST
	        },
	        targetEntity = Product.class)
	@JoinTable(name = "Prod_Size",
	        joinColumns = @JoinColumn(name = "sizeid",
	                nullable = false,
	                updatable = false),
	        inverseJoinColumns = @JoinColumn(name = "prodid",
	                nullable = false,
	                updatable = false),
	        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
	        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private List<Product> productes=new ArrayList<>();
	
	public int getSizeid() {
		return sizeid;
	}
	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}
	public String getSizename() {
		return sizename;
	}
	public void setSizename(String sizename) {
		this.sizename = sizename;
	}
	public List<Product> getProductes() {
		return productes;
	}
	public void setProductes(List<Product> productes) {
		this.productes = productes;
	}
	public Size() {
		super();
	}
	public Size(int sizeid, String sizename, List<Product> productes) {
		super();
		this.sizeid = sizeid;
		this.sizename = sizename;
		this.productes = productes;
	}
	
	

}
