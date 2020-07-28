package org.comstudy21;

public class LeftItem {
	/* <방법>
	 * 1. request에 list를 넣어주는 방법
	 * 2. json을 받아서 template로 뿌려 주는 방법
	 * */
	public String itemName, link;
	
	public LeftItem(String itemName, String link) {
		this.itemName = itemName;
		this.link = link;
	}
	
	public String getTag(){
		return "<li><a href=\""+link+"\">"+itemName+"</a></li>";
	}
}
