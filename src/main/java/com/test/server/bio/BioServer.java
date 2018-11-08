package com.test.server.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * JavaBIO实现服务端
 * @author Administrator
 *
 */
public class BioServer {
	public static void main(String[] args) throws Exception {
		//向操作系统注册服务
		ServerSocket serverSocket = new ServerSocket(8888);
		//等待客户端的请求
		System.out.println("等待客户端连接:");
  		Socket socket = serverSocket.accept();
		//读取客户端的请求
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//服务端输入
		BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
		//服务器将数据返回给客户端
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		String line = null;
		String clientLine = null;
		while(!"exit".equals(line)) {
			line = br.readLine();
			System.out.println("服务器接收到的数据:"+line);
			clientLine = out.readLine();
			pw.println(clientLine);
			//刷新
			pw.flush();
			
		}
		//关闭流
		pw.close();
		br.close();
		socket.close();
		serverSocket.close();
		
	}
	
}
