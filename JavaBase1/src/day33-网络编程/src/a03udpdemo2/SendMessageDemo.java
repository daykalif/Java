package a03udpdemo2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/*
 * 按照下面的要求实现程序
 *
 *      UDP发送数据：数据来自于键盘录入，直到输入的数据是886，发送数据结束
 *      UDP接收数据：因为接收端不知道发送端什么时候停止发送，故采用死循环接收
 */
public class SendMessageDemo {
	public static void main(String[] args) throws IOException {
		// 1.创建对象DatagramSocket的对象
		DatagramSocket ds = new DatagramSocket();

		// 2.打包数据
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入您要说的话：");
			String str = sc.nextLine();
			if ("886".equals(str)) {
				break;
			}
			byte[] bytes = str.getBytes();
			InetAddress address = InetAddress.getByName("255.255.255.255");	// 广播地址
			int port = 10086;
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

			// 3.发送数据
			ds.send(dp);
		}

		// 4.释放资源
		ds.close();
	}
}
