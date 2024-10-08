/*
 * 非捕获分组:分组之后不需要再用本组数据，仅仅是把数据括起来。
 *
 * 身份证号码:
 * 41080119930228457x51080119760902230915040119810705387X130133197204039024430102197606046442
 *
 * 总结：
 * 	1.正则表达式中分组有两种：
 * 		捕获分组、非捕获分组
 * 	2.捕获分组（默认）：
 * 		可以获取每组中的内容反复使用。
 * 	3.组号的特点：
 * 		从1开始，连续不间断
 * 		以左括号为基准，最左边的是第一组
 * 	4.非捕获分组：
 * 		分组之后不需要再用本组数据，仅仅把数据括起来，不占组号。
 * 		(?:) (?=) (?!)都是非捕获分组
 */
public class RegexDemo14 {
	public static void main(String[] args) {
		/*
		 * 身份证号码的简易正则表达式
		 *
		 * 非捕获分组：仅仅是把数据括起来
		 * 			 特点:不占用组号
		 */


		// 这里\\1报错原因:(?:)就是非捕获分组，此时是不占用组号的。
		String regex1 = "[1-9]\\d{16}(?:\\d|X|x)\\1";
		System.out.println("41080119930228457x".matches(regex1));

		// (?:) (?=) (?!)都是非捕获分组，更多的使用第一个
		String regex2 = "[1-9]\\d{16}(\\d Xx)\\1";
		System.out.println("41080119930228457x".matches(regex2));
	}
}
