package com.jikexueyuan.myjavachatclient.main;

import java.awt.EventQueue;

import com.jikexueyuan.myjavachatclient.view.MainWIndow;

public class StartClient {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWIndow frame = new MainWIndow();
					frame.setVisible(true);
					ChatManager.getCM().setWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
