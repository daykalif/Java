package com.itheima.a02mystream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * filter              过滤
 * limit               获取前几个元素
 * skip                跳过前几个元素
 *
 * 注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
 * 注意2：修改Stream流中的数据，不会影响原来集合或者数组中的数据
 */
public class StreamDemo6 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");

		/*
		 * filter   过滤  把张开头的留下，其余数据过滤不要
		 */
		// 匿名内部类：
		list.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String s) {
				// 如果返回值为true，表示当前数据留下
				// 如果返回值为false，表示当前数据舍弃不要
				return s.startsWith("张");
			}
		}).forEach(s -> System.out.println(s));
		System.out.println("====================================");


		/*
			Stream<String> stream1 = list.stream().filter(s -> s.startsWith("王"));
			Stream<String> stream2 = stream1.filter(s -> s.length() == 3);
			stream1.forEach(s -> System.out.println(s));	// 报错：返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
		*/

		// lambda表达式：
		list.stream()
				.filter(s -> s.startsWith("张"))
				.filter(s -> s.length() == 3)
				.forEach(s -> System.out.println(s));

		System.out.println("====================================");
		System.out.println("集合的数据不会变：" + list);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");




		/*
		 * limit               获取前几个元素
		 * skip                跳过前几个元素
		 *
		 * "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤"
		 */
		list.stream().limit(3).forEach(s -> System.out.println(s));
		System.out.println("====================================");
		list.stream().skip(4).forEach(s -> System.out.println(s));


		/*
		 * 课堂练习：获取 "张强", "张三丰", "张翠山"
		 *
		 * 第一种思路：先获取前面6个元素："张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山"，然后跳过前面3个元素
		 * list.stream().limit(6).skip(3).forEach(s -> System.out.println(s));
		 *
		 * 第二种思路：先跳过3个元素："张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤"，然后再获取前面3个元素："张强", "张三丰", "张翠山"
		 * list.stream().skip(3).limit(3).forEach(s -> System.out.println(s));
		 */
	}
}
