package com.itheima.runtime;

import java.io.IOException;

/*
 * public static Runtime getRuntime() 当前系统的运行环境对象
 * public void exit(int status) 停止虚拟机
 * public int availableProcessors() 获得CPU的线程数
 * public long maxMemory() JVM能从系统中获取总内存大小(单位byte)
 * public long totalMemory() JVM已经从系统中获取总内存大小(单位byte)
 * public long freeMemory() JVM剩余内存大小(单位byte)
 * public Process exec(string command) 运行cmd命令
 */
public class RunTimeDemo1 {
	public static void main(String[] args) throws IOException {
		// 1.获取Runtime的对象
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();
		System.out.println(r1 == r2);

		// 2.exit 停止虚拟机
		// Runtime.getRuntime().exit(0);
		// System.out.println("看看我执行了吗?");

		// 3.获得CPU的线程数
		System.out.println(Runtime.getRuntime().availableProcessors());    //	12

		// 4.总内存大小,单位byte字节
		System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);    // 8192M（单位：兆）

		// 5.已经获取的总内存大小,单位byte字节
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);    // 520M

		// 6.剩余内存大小
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);    // 513M

		/*
		 * 7.运行cmd命令（shutdown :关机）
		 *   加上参数才能执行
		 * 		-s :默认在1分钟之后关机
		 * 		-s -t 指定时间 : 指定关机时间
		 * 		-a :取消关机操作
		 * 		-r: 关机并重启
		 */
		Runtime.getRuntime().exec("shutdown -s -t 3600");        // exec：用于异常处理	3600s：60秒 * 60分 = 1h
	}
}
