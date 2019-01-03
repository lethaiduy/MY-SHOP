package com.myshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "News")

public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newsid")
	private int newsid;

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public int getNewsid() {
		return newsid;
	}

	@Column(name = "date_sub")
	private Date dateSub;

	public Date getDateSub() {
		return dateSub;
	}

	public void setDateSub(Date dateSub) {
		this.dateSub = dateSub;
	}

	@Column(name = "detail")
	private String detail;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "image")
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "title")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Transient
	private String base64;

	@SuppressWarnings("restriction")
	public String getBase64() {
		return this.base64 = Base64.encode(this.image);
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public News() {
		super();
	}

	public News(int newsid, Date dateSub, String detail, byte[] image, String title, String base64) {

		this.newsid = newsid;
		this.dateSub = dateSub;
		this.detail = detail;
		this.image = image;
		this.title = title;
		this.base64 = base64;
	}

}