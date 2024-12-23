package com.itheima.a11threadsafe4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
	static int ticket = 0;

	// 所有对象共享同一把锁
	static Lock lock = new ReentrantLock();

	@Override
	public void run() {
		// 1.循环
		while (true) {
			// 2.同步代码块
			// synchronized (MyThread.class){
			lock.lock();    //2 //3
			try {
				// 3.判断
				if (ticket == 100) {
					break;
					// 4.判断
				} else {
					Thread.sleep(10);
					ticket++;
					System.out.println(getName() + "在卖第" + ticket + "张票！！！");
				}
				//  }
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
