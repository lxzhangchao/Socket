package com.jikexueyuan.testmysetversocket1.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class ServerListener1 extends Thread {
	@Override
	public void run() {
		//1-65535
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while (true) {
				//block
				Socket socket = serverSocket.accept();
				//建立连接
				JOptionPane.showMessageDialog(null, "有客户端链接到本机的12345端口");
				//将socket传递给新的线程
				ChatSocket1 cs=new ChatSocket1(socket);
				cs.start();
				ChatManager1.getChatManager().add(cs);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
