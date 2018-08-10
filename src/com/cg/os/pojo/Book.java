//Class Book having collection of Books.

package com.cg.os.pojo;

public class Book {

	private int productId;
	private String productName;
	private String productDescription;
	private double cost;

	public Book(int productId, String productName, String productDescription, double cost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.cost = cost;
	}

	public Book() {
		super();

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Book [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", cost=" + cost + "]";
	}

}
