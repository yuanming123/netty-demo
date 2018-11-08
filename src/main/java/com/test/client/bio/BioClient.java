package com.test.client.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * BIO客户端
 * @author Administrator
 *
 */
public class BioClient {
	public static void main(String[] args) throws Exception {
		//需要访问的服务器
		Socket socket = new Socket("127.0.0.1", 8888);
		//获得输入流
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入...");
		//将数据发送到服务器
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		//获取服务端的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String serverLine = null;
		String line = null;
		while(!"exit".equals(line)) {
			line = scanner.nextLine();
			pw.println(line);
			//刷新
			pw.flush();
			serverLine = br.readLine();
			System.out.println("服务端返回的数据为:"+serverLine);
			
			
		}		
		scanner.close();
		socket.close();
	}
}
