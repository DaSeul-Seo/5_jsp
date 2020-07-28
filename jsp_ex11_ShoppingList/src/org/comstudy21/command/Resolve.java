package org.comstudy21.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Resolve {
	// 프레임워크 = 종합선물세트(필요없는 것을 빼면됨)
	// 라이브러리 = 내가 필요한 것을 갖다 붙임(jQuery처럼)
	public boolean isRedirect = false;
	public String viewName="";
	
	public Resolve() {}

	public Resolve(boolean isRedirect, String viewName) {
		this.isRedirect = isRedirect;
		this.viewName = viewName;
	}
	
	public void forword(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		if(isRedirect){
			resp.sendRedirect(req.getContextPath()+ "/" + viewName);
		}else{
			viewName = req.getAttribute("prefix") + "/" + viewName + req.getAttribute("suffix");
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
	}
}
