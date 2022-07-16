package com.imooc.tel;

// 第一代手机，可以打电话
public class Telphone {
	
	private String brand;
	
	private int price;
	
	public void call() {
		System.out.println("手机可以打电话");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
