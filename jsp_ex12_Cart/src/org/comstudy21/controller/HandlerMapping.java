package org.comstudy21.controller;

import java.util.Hashtable;

public class HandlerMapping {
	// HandlerMapping은 요청받은 URL이 어떤 Controller로 가야하는지 선택
	private Hashtable<String, Controller> handler = new Hashtable<>();
	
	public HandlerMapping() {
		handler.put("shop", new ShopController());
		handler.put("bbs", new BbsController());
	}
	
	public void putController(String path, Controller ctrl){
		handler.put(path, ctrl);
	}
	
	public Controller getController(String path){
		return handler.get(path);
	}
}
