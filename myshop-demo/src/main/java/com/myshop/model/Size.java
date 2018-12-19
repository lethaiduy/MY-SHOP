package com.myshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Prod_Size", joinColumns = { @JoinColumn(name = "sizeid") }, inverseJoinColumns = { @JoinColumn(name = "prodid") })
	private List<Product> productes= new ArrayList<>();

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


}
