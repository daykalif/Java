package com.itheima.jdk8Date;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
 * static ZonedDateTime now()                    获取当前时间的ZonedDateTime对象
 * static ZonedDateTime ofXxxx(...)              获取指定时间的ZonedDateTime对象
 * ZonedDateTime withXxx(时间)                    修改时间系列的方法
 * ZonedDateTime minusXxx(时间)                   减少时间系列的方法
 * ZonedDateTime plusXxx(时间)                    增加时间系列的方法
 *
 * 细节：
 * 	JDK8新增的时间对象都是不可变的
 * 	如果我们修改了，减少了，增加了时间，
 * 	那么调用者是不会发生改变的，会产生一个新的时间。
 */
public class A03_ZoneDateTimeDemo {
	public static void main(String[] args) {
		// 1.获取当前时间对象(带时区)
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now);

		// 2.获取指定的时间对象(带时区)1/年月日时分秒纳秒方式指定
		ZonedDateTime time1 = ZonedDateTime.of(2023, 10, 1,
				11, 12, 12, 0, ZoneId.of("Asia/Shanghai"));
		System.out.println(time1);

		// 通过Instant + 时区的方式指定获取时间对象
		Instant instant = Instant.ofEpochMilli(0L);
		ZoneId zoneId = ZoneId.of("Asia/Shanghai");
		ZonedDateTime time2 = ZonedDateTime.ofInstant(instant, zoneId);
		System.out.println(time2);

		// 3.withXxx 修改时间系列的方法
		ZonedDateTime time3 = time2.withYear(2000);
		System.out.println(time3);

		// 4.减少时间
		ZonedDateTime time4 = time3.minusYears(1);
		System.out.println(time4);

		// 5.增加时间
		ZonedDateTime time5 = time4.plusYears(1);
		System.out.println(time5);
	}
}
