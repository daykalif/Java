package com.itheima.classLoader;

/*
 * 类加载器：
 * 		负责将.class文件（存储的物理文件）加载到内存中
 *
 * 	类加载时机：
 * 		1.创建类的实例（对象）
 * 		2.调用类的类方法
 * 		3.访问类或者接口的类变量，或者为该类变量赋值
 * 		4.使用反射方式来强制创建某个类或接口对应的java.lang.Class对象
 * 		5.初始化某个类的子类
 * 		6.直接使用java.exe命令来运行某个主类。
 *
 * 		总结：用到就加载，不用不加载
 *
 * 类加载的过程的小结：
 * 		1.当一个类被使用的时候，才会加载到内存
 * 		2.类加载的过程如下：
 * 			加载、验证、准备、解析、初始化
 *
 * 类加载器的分类：
 * 		1.启动类加载器（Bootstrap Class Loader）：虚拟机内置的类加载器。
 * 		2.平台类加载器（Platform Class Loader）：负责加载JDK中一些特殊的模块。
 * 		3.系统类加载器（System Class Loader）：负责加载用户类路径上所指定的类库。
 */
public class Test1 {
	public static void main(String[] args) {
		// 获得系统类加载器
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器:" + systemClassLoader);

		// 获取系统类加载器的父加载器，也就是：平台类加载器
		ClassLoader classLoader1 = systemClassLoader.getParent();
		System.out.println("平台类加载器:" + classLoader1);

		// 获取平台类加载器的父加载器，也就是：启动类加载器
		ClassLoader classLoader2 = classLoader1.getParent();
		System.out.println("启动类加载器:" + classLoader2);
	}
}
