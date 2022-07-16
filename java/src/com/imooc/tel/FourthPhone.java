package com.imooc.tel;

// 第四代手机，可以拍照、玩游戏
public class FourthPhone extends ThirdPhone implements IPhoto {
	
	@Override
	public void photo() {
		System.out.println("手机可以拍照");
	}
	
	public void game() {
		System.out.println("手机可以玩游戏");
	}
}
