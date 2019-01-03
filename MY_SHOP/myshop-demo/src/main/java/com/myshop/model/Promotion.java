package com.myshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Promotion")
public class Promotion {
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
