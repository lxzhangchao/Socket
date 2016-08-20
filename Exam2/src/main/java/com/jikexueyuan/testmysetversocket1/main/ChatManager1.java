package com.jikexueyuan.testmysetversocket1.main;

import java.util.Vector;

public class ChatManager1 {

	private ChatManager1(){}
	private static final ChatManager1 cm = new ChatManager1();
	public static ChatManager1 getChatManager() {
		return cm;
	}
	
	Vector<ChatSocket1> vector = new Vector<ChatSocket1>();
	
	public void add(ChatSocket1 cs) {
		vector.add(cs);
	}
	
	public void remove(ChatSocket1 cs) {
		vector.remove(cs);
	}
	
	public void publish(ChatSocket1 cs,String out) {
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket1 csChatSocket = vector.get(i);
			if (!cs.equals(csChatSocket)) {
				csChatSocket.out(out);
			}
		}
	}
}
