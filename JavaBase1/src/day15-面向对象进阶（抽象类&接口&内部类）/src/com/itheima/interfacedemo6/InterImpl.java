package com.itheima.interfacedemo6;

public class InterImpl implements InterA, InterB {
	@Override
	public void method() {
		System.out.println("实现类重写的抽象方法");
	}

	// 默认方法不是抽象方法，所以不强制被重写。但是如果被重写，重写的时候去掉default关键字。如果有重名的2个default方法，实现类必须强制重写。
	@Override
	public void show() {
		System.out.println("重写接口中的默认方法");
	}
}
