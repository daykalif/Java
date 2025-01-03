package com.itheima.myexception.test1;

import java.util.Scanner;

/*
 * 需求：
 *      键盘录入自己心仪的女朋友姓名和年龄。
 *      姓名的长度在 3 - 10之间，
 *      年龄的范围为 18 - 40岁,
 *      超出这个范围是异常数据不能赋值，需要重新录入,一直录到正确为止。
 *
 * 提示：
 *      需要考虑用户在键盘录入时的所有情况。
 *      比如：录入年龄时超出范围，录入年龄时录入了abc等情况
 */
public class Test {
	public static void main(String[] args) {
		// 1.创建键盘录入的对象
		Scanner sc = new Scanner(System.in);

		// 2.创建女朋友的对象
		GirlFriend gf = new GirlFriend();

		while (true) {
			// 3.接收女朋友的姓名
			try {
				System.out.println("请输入你心仪的女朋友的名字");
				String name = sc.nextLine();
				gf.setName(name);

				// 4.接收女朋友的年龄
				System.out.println("请输入你心仪的女朋友的年龄");
				String ageStr = sc.nextLine();
				int age = Integer.parseInt(ageStr);
				gf.setAge(age);
				break;    // 如果所有的数据都是正确的，那么跳出循环
			} catch (NumberFormatException e) {
				System.out.println("年龄的格式有误，请输入数字");
				// continue;	// 可以省略不写
			} catch (RuntimeException e) {
				System.out.println("姓名的长度或者年龄的范围有误");
				// continue;	// 可以省略不写
			}
		}

		// 5.打印
		System.out.println(gf);
	}
}
