package com.itheima.interfacedemo7;

/*
 *	JDK8以后接口中新增的方法：
 * 		- 允许在接口中定义静态方法，需要用static修饰
 *
 * 	接口中静态方法的定义格式：
 * 		格式：public static 返回值类型 方法名(参数列表){}
 * 		范例：public static void show(){}
 *
 * 	接口中静态方法的注意事项：
 * 		静态方法只能通过接口名调用，不能通过实现类名或者对象名调用
 * 		public可以省略，static不能省略
 */
public class Test {
	public static void main(String[] args) {
		// 调用接口中的静态方法
		Inter.show();

		// 调用实现类中的静态方法
		InterImpl.show();

		// 子类把从父类继承下来的虚方法表里面的方法进行覆盖了，这才叫重写。
	}
}
