package com.jikexueyuan.testmysetversocket1.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket1 extends Thread {
Socket socket;
	
	public ChatSocket1(Socket s){
		this.socket = s;
	}
	
	public void out(String out) {
		try {
			socket.getOutputStream().write((out+"\n").getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
			try {
				BufferedReader br=new BufferedReader(

					new InputStreamReader(
							socket.getInputStream(),"UTF-8"));
				String line=null;
				while ((line=br.readLine())!=null) {
					ChatManager1.getChatManager().publish(this,line);
				}
				br.close();
//				File file = new File("target.pdf");
//				FileInputStream fis =new FileInputStream(file);
//				InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
//				BufferedReader br = new BufferedReader(isr);
//				File newfile = new File("newtarget.pdf");
//				FileOutputStream fos =new FileOutputStream(newfile);
//				OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
//				BufferedWriter bw = new BufferedWriter(osw);
//				bw.close();
//				osw.close();
//				fos.close();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
