package org.comstudy21.model;

public class Product {
	// 상품객체를 빈으로
	private int idx, price; // 상품 번호, 상품가격
	private String title; // 상품명
	
	public Product() {
		idx = 0;
		title = "";
		price = 0;
	}

	public Product(int idx, String title, int price) {
		this.idx = idx;
		this.title = title;
		this.price = price;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Product [idx=" + idx + ", title=" + title + ", price=" + price + "]";
	}
	
	// hashCode, equals
	// 컬렉션에서 비교하거나 정렬할때 사용하려고 재정의
	@Override
	public int hashCode() {
		return idx;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product){
			Product p = (Product)obj;
			if(this.idx == p.getIdx()){
				return true;
			}
		}
		return false;
	}
}
