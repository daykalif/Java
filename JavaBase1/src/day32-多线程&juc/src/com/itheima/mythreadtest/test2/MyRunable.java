package com.itheima.mythreadtest.test2;

import com.itheima.mythreadtest.test1.MyThread;

// 第二种方式实现多线程，测试类中MyRunable只创建一次，所以不需要加static
public class MyRunable implements Runnable {
	int count = 100;

	@Override
	public void run() {
		// 1.循环
		while (true) {
			// 2.同步代码块
			synchronized (MyThread.class) {
				// 3.判断共享数据（已经到末尾）
				if (count < 10) {
					System.out.println("礼物还剩下" + count + "不再赠送");
					break;
				} else {
					// 4.判断共享数据（没有到末尾）
					count--;
					System.out.println(Thread.currentThread().getName() + "在赠送礼物，还剩下" + count + "个礼物!!!");
				}
			}
		}
	}
}
