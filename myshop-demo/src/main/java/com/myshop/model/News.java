package com.myshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "News")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "news_id")
	private int news_id;
	@Column(name = "date_sub")
	private Date dateSub;
	@Column(name = "detail")
	private String detail;
	@Column(name = "title")
	private String title;
	@Lob
	@Column(name = "image")
	private byte[] image;

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

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public News() {
		super();
	}

	public News(int news_id, Date dateSub, String detail, String title, byte[] image) {
		super();
		this.news_id = news_id;
		this.dateSub = dateSub;
		this.detail = detail;
		this.title = title;
		this.image = image;
	}

}