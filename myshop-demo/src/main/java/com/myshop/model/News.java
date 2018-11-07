package com.myshop.model;

import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "News")
public class News {
	
	@Transient 
	private String base64;
	//Annotation so it does not persist in the database
	public String getBase64() {
	    //Convert the data type byte to String, store it in the variable and return it
	    return this.base64 = Base64.getEncoder().encodeToString(image); 
	}

	public void setBase64(String base64) {
	    this.base64 = base64;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newsid")
	private int newsid;
	@Column(name = "date_sub")
	private Date dateSub;
	@Column(name = "detail")
	private String detail;
	@Column(name = "title")
	private String title;
	@Lob
	@Column(name = "image")
	private byte[] image;

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public Date getDateSub() {
		return dateSub;
	}

	public void setDateSub(Date dateSub) {
		this.dateSub = dateSub;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public News() {
		super();
	}

	public News(int newsid, Date dateSub, String detail, String title, byte[] image) {
		super();
		this.newsid = newsid;
		this.dateSub = dateSub;
		this.detail = detail;
		this.title = title;
		this.image = image;
	}

}