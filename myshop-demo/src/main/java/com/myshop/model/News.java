package com.myshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "News")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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


}