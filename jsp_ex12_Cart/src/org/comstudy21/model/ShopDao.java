package org.comstudy21.model;

import java.util.ArrayList;

public class ShopDao {
	private static ArrayList<Product> pList = new ArrayList<>();
	static{
		// static 초기화 => 고치지 못함
		pList.add(new Product(1, "Sonata", 2500));
		pList.add(new Product(2, "Granduer", 3800));
		pList.add(new Product(3, "SM6", 3500));
		pList.add(new Product(4, "K7", 3500));
		pList.add(new Product(5, "BMW", 5000));
		pList.add(new Product(6, "Volvo", 6500));
		pList.add(new Product(7, "Avante", 1800));
	}
	
	public ArrayList<Product> selectAll(){
		return pList;
	}
	
	public Product selectByIdx(Product dto){
		int idx = pList.indexOf(dto);
//		System.out.println(idx);
		if(idx != -1){
			return pList.get(idx);			
		} else{
			return null;
		}
	}
	
	public static void test(String[] args) {
		ShopDao dao = new ShopDao();
		Product p = dao.selectByIdx(new Product(2, null, 0));
		System.out.println(p);
	}
}
