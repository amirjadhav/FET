package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;
	@Column(length = 500)
	private String imageUrl;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String categoryName, String imageUrl) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", imageUrl=" + imageUrl + "]";
	}

}
