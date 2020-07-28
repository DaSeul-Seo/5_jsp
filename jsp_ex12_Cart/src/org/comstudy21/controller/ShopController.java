package org.comstudy21.controller;

import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.comstudy21.model.Product;
import org.comstudy21.model.ShopDao;

// Controller에서 안하고 각각의 Controller를 만들어서 하는 이유
// 각각의 하위 메뉴등이 다르니까
public class ShopController implements Controller {
	public static ShopDao shopDao = new ShopDao();
	private HttpSession session = null;
	
	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		String path = mkPath(req, resp);
		String viewName = "shop/list";
		
		session = req.getSession();
				
		if("list".equals(path)){
			ArrayList<Product> pList = shopDao.selectAll();
			req.setAttribute("pList", pList);
			viewName = "shop/list";
		}
		else if("home".equals(path)){
			viewName="home";
		}
		else if("cart".equals(path)){
			// 장바구니 기능 - session의 List에 저장한다.
			if(req.getParameter("idx") != null){
			int idx = Integer.parseInt(req.getParameter("idx"));
			Product p = shopDao.selectByIdx(new Product(idx, null, 0));
			
			HashSet<Product> cartList = null;
			if(session.getAttribute("cartList") != null){
				cartList = (HashSet<Product>)session.getAttribute("cartList");
			} else{
				cartList = new HashSet<>();
				session.setAttribute("cartList", cartList);
			}
			// session의 장바구니에 누적된다.
			cartList.add(p);
			// req.setAttribute("cartList", cartList);
			viewName="shop/cart";
			} else{
				viewName="shop/cart";				
			}
		}
		else if ("detail".equals(path)) {
			if (req.getParameter("idx") != null) {
				int idx = Integer.parseInt(req.getParameter("idx"));
				Product p = shopDao.selectByIdx(new Product(idx, null, 0));
				req.setAttribute("product", p);
			}
			viewName = "shop/detail";
		} else if ("cart_remove".equals(path)) {
			int idx = Integer.parseInt(req.getParameter("idx"));
			System.out.println(">>>>>>>>> idx : " + idx);
			// session의 cartList에서 idx와 같은 상품을 제거한다.

			viewName = "shop/cart";
		}
		return new ModelAndView(viewName);
	}
}