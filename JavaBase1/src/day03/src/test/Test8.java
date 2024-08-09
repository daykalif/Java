package test;

public class Test8 {
	/**
	 * 00111000
	 *
	 * 0/1 bit	比特位
	 * 8个bit = byte 	字节（计算机最小的存储单元）
	 *
	 * 最大值：0111 1111 （127）
	 * 最小值：1111 1111 （-127）
	 */

	/**
	 * 原码：
	 * 		十进制数据的二进制表现形式，最左边是符号位，0为正，1为负。
	 * 原码的弊端：
	 * 		利用原码对整数进行计算是不会有问题的。
	 * 		但是如果是负数计算，结果就出错，实际运算的结果，跟我们预期的结果是相反的。
	 *
	 *
	 * 正数计算：
	 * 0：0000 0000，加1
	 * 1：0000 0001，再加1
	 * 2：0000 0010，再加1
	 * 3：0000 0011，
	 * ...
	 *
	 * 负数计算：
	 * -0：1000 0000，加1
	 * 正确值：+1
	 * 实际值：-1（1000 0001）
	 *
	 * 以-1（1000 0001）为基础，加1
	 * 正确值：0
	 * 实际值：-2（1000 0010）
	 *
	 * 以-2（1000 0010）为基础，加1
	 * 正确值：-1
	 * 实际值：-3（1000 0011）
	 *
	 *
	 * 反码出现的目的：
	 * 		为了解决原码不能计算负数的问题而出现的。
	 * 反码计算规则：
	 * 		正数的反码不变，负数的反码在原码的基础上，符号位不变，数值取反，0变1，1变0。
	 * 反码的弊端：
	 * 		负数运算的时候，如果结果不跨0，是没有任何问题的，但是如果结果跨0，跟实际结果会有1的偏差。
	 *
	 * 举例：
	 * -56的原码：1011 1000
	 * -56的反码：1100 0111，对反码进行+1，得到1100 1000（即为-55的反码），所以得到结果为：-55
	 *  55的原码：0011 0111
	 * -55的原码：1011 0111
	 * -55的反码：1100 1000
	 *
	 *
	 * 补码出现的目的：
	 * 		为了解决负数计算跨0的问题而出现的。
	 * 补码的计算规则：
	 * 		正数的补码不变，负数的补码在反码的基础上+1。
	 * 		另外补码还能多记录一个特殊的值-128，该数据在1个字节下，没有原码和反码。
	 * 补码的注意点：
	 * 		计算机中的存储和计算都是以补码的形式进行的。
	 */


	/**
	 * byte类型的10（1个字节）：0000 1010
	 * short类型的10（2个字节）：0000 0000 0000 1010
	 * int类型的10（4个字节）：0000 0000 0000 0000 0000 0000 0000 1010
	 * long类型的10（8个字节）：0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1010
	 */


	// 隐式转换
	public static void main(String[] args) {
		byte a = 10;    // 0000 1010
		int b = a;        // 0000 0000 0000 1010
		System.out.println(b);	// 0000 0000 0000 1010输出时展示十进制：10
	}


	public static void main1(String[] args) {
		int a = 300;	// 0000 0000 0000 0000 0000 0001 0010 1100
		byte b = (byte)a;	// (--去除--0000 0000 0000 0000 0000 0001---) 0010 1100
		System.out.println(b);	// 0010 1100 输出时展示十进制：44
	}


	public static void main2(String[] args) {
		int a = 200;	// 0000 0000 0000 0000 0000 0000 1100 1000
		byte b = (byte)a;	// (--去除--0000 0000 0000 0000 0000 0000---) 1100 1000
		System.out.println(b);	// 1100 1000 输出时展示十进制：-56
	}

/**
 *	运算符：&
 *	含义：逻辑与
 *  运算规则：0为false，1为true
 */
	public static void main3(String[] args) {
		int a = 200;					// 	  0000 0000 0000 0000 0000 0000 1100 1000
		int b = 10;						// 	& 0000 0000 0000 0000 0000 0000 0000 1010
										//    -----------------------------------------
										//    0000 0000 0000 0000 0000 0000 0000 1000
		System.out.println(a & b);		//  输出时展示十进制：8
	}


	/**
	 * 运算符：｜
	 * 含义：逻辑或
	 * 运算规则：0为false，1为true
	 */
	public static void main4(String[] args) {
		int a = 200;					// 	  0000 0000 0000 0000 0000 0000 1100 1000
		int b = 10;						// 	| 0000 0000 0000 0000 0000 0000 0000 1010
										//    -----------------------------------------
										//    0000 0000 0000 0000 0000 0000 1100 1010
		System.out.println(a | b);		//  输出时展示十进制：202
	}


	/**
	 *	运算符：<<
	 *	含义：左移
	 *	运算规则：向左移动，低位补0
	 */
	public static void main5(String[] args) {
		int a = 200;					// 	  |0000 0000 0000 0000 0000 0000 1100 1000|
										//	00|00 0000 0000 0000 0000 0000 1100 100000|
		System.out.println(a << 2);		//  00 0000 0000 0000 0000 0000 1100 100000输出时展示十进制：800
	}



	/**
	 *	运算符：>>
	 *	含义：右移
	 *	运算规则：向右移动，高位补0或1（正数补0，负数补1）
	 */
	public static void main6(String[] args) {
		int a = 200;					// 	  |0000 0000 0000 0000 0000 0000 1100 1000|
										//	  |000000 0000 0000 0000 0000 0000 1100 10|00
		System.out.println(a << 2);		//  000000 0000 0000 0000 0000 0000 1100 10输出时展示十进制：50
	}


	/**
	 *	运算符：>>>
	 *	含义：无符号右移
	 *	运算规则：向右移动，高位补0
	 *  示例参考上
	 */
}
