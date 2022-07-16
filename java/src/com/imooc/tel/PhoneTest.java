package com.imooc.tel;

public class PhoneTest {
	
	public static void main(String[] args) {
		
		FourthPhone phone = new FourthPhone();
		
		phone.call();
		phone.message();
		phone.vedio();
		phone.game();
		phone.photo();
		
		System.out.println("--------------");
		
		IPhoto ip = new FourthPhone();
		ip.photo();
		
		ip = new Camera();
		ip.photo();
		
	}
}
