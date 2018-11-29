package com.myshop.model;

public class Prod_Size {

	private int sizeid;
	private int prodid;

	public int getSizeid() {
		return sizeid;
	}

	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public Prod_Size(int sizeid, int prodid) {
		super();
		this.sizeid = sizeid;
		this.prodid = prodid;
	}
	
	

}
