package com.itheima.a02mystream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

/*
 * map                 转换流中的数据类型
 *
 * 注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
 * 注意2：修改Stream流中的数据，不会影响原来集合或者数组中的数据
 */
public class StreamDemo8 {
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list, "张无忌-15", "周芷若-14", "赵敏-13", "张强-20", "张三丰-100", "张翠山-40", "张良-35", "王二麻子-37", "谢广坤-41");
		/*
		 * 需求：只获取里面的年龄并进行打印；由String，获取int
		 *
		 * 第一个类型：流中原本的数据类型
		 * 第二个类型：要转成之后的类型
		 *
		 * apply的形参s：依次表示流里面的每一个数据
		 * 返回值：表示转换之后的数据
		 *
		 * 当map方法执行完毕之后，流上的数据就变成了整数
		 * 所以在下面forEach当中，s依次表示流里面的每一个数据，这个数据现在就是整数了
		 *
		 * 匿名函数类实现：
		 */
		list.stream().map(new Function<String, Integer>() {    // 泛型不能写基本数据类型
			@Override
			public Integer apply(String s) {
				String[] arr = s.split("-");
				String ageString = arr[1];
				int age = Integer.parseInt(ageString);
				return age;
			}
		}).forEach(s -> System.out.println(s));

		System.out.println("------------------------");

		// lambda表达式书写：
		list.stream()
				.map(s -> Integer.parseInt(s.split("-")[1]))
				.forEach(s -> System.out.println(s));
	}
}
