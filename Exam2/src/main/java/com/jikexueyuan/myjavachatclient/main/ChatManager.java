package com.jikexueyuan.myjavachatclient.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.FileUtils;

import com.jikexueyuan.myjavachatclient.view.MainWIndow;


public class ChatManager {

	private ChatManager(){}
	private static final ChatManager instance = new ChatManager();
	public static ChatManager getCM() {
		return instance;
	}
	
	MainWIndow window;
	String IP;
	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	
	public void setWindow(MainWIndow window) {
		this.window = window;
		window.appendText("文本框已经和ChatManager绑定了。");
	}
	
	public void connect(String ip) {
		this.IP = ip;
		new Thread(){

			@Override
			public void run() {
				try {
					socket = new Socket(IP, 12345);
					writer = new PrintWriter(
					new OutputStreamWriter(
							socket.getOutputStream()));
			
					reader = new BufferedReader(
							new InputStreamReader(
									socket.getInputStream()));
					File file = new File("target.pdf");
					FileInputStream fis =new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
					BufferedReader br = new BufferedReader(isr);
					File newfile = new File("newtarget.pdf");
					FileOutputStream fos =new FileOutputStream(newfile);
					OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
					BufferedWriter bw = new BufferedWriter(osw);
					bw.close();
					osw.close();
					fos.close();
					
					String line;
					while ((line = reader.readLine()) != null) {
						window.appendText("收到："+line);
					}
					writer.close();
					reader.close();
					writer = null;
					reader = null;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	public void send(String out) {
		if (writer != null) {
			writer.write(out+"\n");
			writer.flush();
		}else {
			window.appendText("当前的链接已经中断");
		}
	}
}
