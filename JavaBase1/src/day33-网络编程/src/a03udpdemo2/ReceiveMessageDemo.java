package a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 按照下面的要求实现程序
 *
 *      UDP发送数据：数据来自于键盘录入，直到输入的数据是886，发送数据结束
 *      UDP接收数据：因为接收端不知道发送端什么时候停止发送，故采用死循环接收
 */
public class ReceiveMessageDemo {
	public static void main(String[] args) throws IOException {
		// 1.创建对象DatagramSocket的对象
		DatagramSocket ds = new DatagramSocket(10086);

		// 2.接收数据包
		byte[] bytes = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

		while (true) {
			ds.receive(dp);

			// 3.解析数据包
			byte[] data = dp.getData();
			int len = dp.getLength();
			String ip = dp.getAddress().getHostAddress();
			String name = dp.getAddress().getHostName();

			// 4.打印数据
			System.out.println("ip为：" + ip + ",主机名为：" + name + "的人，发送了数据：" + new String(data, 0, len));
		}
	}
}
