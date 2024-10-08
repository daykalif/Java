package com.itheima.test;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 键盘录入一些1~100之间的整数，并添加到集合中。
 * 直到集合中所有数据和超过200为止。
 */
public class Test1 {
	public static void main(String[] args) {
		// 1.创建一个集合用来添加整数
		ArrayList<Integer> list = new ArrayList<>();    // 集合中是不能存储基本数据类型的，如果想要存基本数据类型，需要转成对应的包装类

		// 2.键盘录入数据添加到集合中
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入一个整数");
			String numStr = sc.nextLine();    // sc.next()或sc.nextInt()会在输入空格时就会终止输入，因此这里需要使用sc.nextLine()，表示接收到回车才终止
			int num = Integer.parseInt(numStr); // 先把异常数据先进行过滤
			if (num < 1 || num > 100) {
				System.out.println("当前数字不在1~100的范围当中，请重新输入");
				continue;
			}
			/*
			 * 添加到集合中
			 *
			 * 细节:
			 * 	num:基本数据类型
			 * 	集合里面的数据是Integer
			 * 	在添加数据的时候触发了自动装箱
			 */
			list.add(num);    // 这行代码相当于 list.add(Integer.valueOf(num));
			// 统计集合中所有的数据和
			int sum = getSum(list);
			// 对sum进行判断
			if (sum > 200) {
				System.out.println("集合中所有的数据和已经满足要求");
				break;
			}
		}
	}


	private static int getSum(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			// i:索引
			// list.get(i);	自动拆箱
			int num = list.get(i);
			sum = sum + num; // +=
		}
		return sum;
	}
}
