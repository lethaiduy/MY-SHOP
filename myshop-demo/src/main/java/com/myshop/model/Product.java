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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Entity
@Table(name = "Product")
public class Product {

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prodid")
	private int prodid;
	@Column(name = "prodname")
	private String prodname;
	@Column(name = "image")
	private byte[] image;
	@Column(name = "brand")
	private String brand;
	@Column(name = "fabric")
	private String fabric;
	@Column(name = "price")
	private long price;
	@Column(name = "quantity")
	private int quantity;

	@Transient
	private String base64;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "prodgrpid")
	private ProductGrp productGrp;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="productes")
	private List<Size> sizes = new ArrayList<>();
    
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "promid")
	private Promotion promotion;
	
	@SuppressWarnings("restriction")
	public String getBase64() { return this.base64 =
	  Base64.encode(this.image); }

	public void setBase64(String base64) {
	 this.base64 = base64; }

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	public ProductGrp getProductGrp() {
		return productGrp;
	}

	public void setProductGrp(ProductGrp productGrp) {
		this.productGrp = productGrp;
	}

	public Product() {
		super();
	}



}
