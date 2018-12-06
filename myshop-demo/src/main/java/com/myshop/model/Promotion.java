package com.myshop.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Promotion")
public class Promotion {

	
	
	public List<Product> getPrd() {
		return prd;
	}
	public void setPrd(List<Product> prd) {
		this.prd = prd;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "promid")
	private int promid;
	@Column(name = "promname")
	private String promname;
	@Column(name = "datestart")
	private Date datestart;
	@Column(name = "datefinish")
	private Date datefinish;
	@Column(name = "persdisc")
	private String persdisc;
	@ManyToMany(fetch = FetchType.LAZY,
	        cascade =
	        {
	                CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST
	        },
	        targetEntity = Size.class)
	@JoinTable(name = "Prod_Prom",
	        inverseJoinColumns = @JoinColumn(name = "promid",
	                nullable = false,
	                updatable = false),
	        joinColumns = @JoinColumn(name = "prodid",
	                nullable = false,
	                updatable = false),
	        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
	        inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private List<Product> prd=  new ArrayList<>();
	/*@OneToMany(fetch = FetchType.LAZY,mappedBy="promotion")
	private List<Prod_Prom> prmvsprd;
	*/
	
	public int getPromid() {
		return promid;
	}
	public void setPromid(int promid) {
		this.promid = promid;
	}
	public String getPromname() {
		return promname;
	}
	public void setPromname(String promname) {
		this.promname = promname;
	}
	public Date getDatestart() {
		return datestart;
	}
	public void setDatestart(Date datestart) {
		this.datestart = datestart;
	}
	public Date getDatefinish() {
		return datefinish;
	}
	public void setDatefinish(Date datefinish) {
		this.datefinish = datefinish;
	}
	public String getPersdisc() {
		return persdisc;
	}
	public void setPersdisc(String persdisc) {
		this.persdisc = persdisc;
	}
	
	public Promotion() {
		super();
	}
	
	
	
}
