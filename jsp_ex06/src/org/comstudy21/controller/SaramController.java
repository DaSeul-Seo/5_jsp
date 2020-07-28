package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saram/*")
public class SaramController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	String ctxPath;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// mapping 해서 페이지를 바꾸어주는 것.
		context = getServletContext();
		
		String reqUri = request.getRequestURI();
//		System.out.println(">>>>> " + uri);
//		context.log(">>>>> " + uri); // 권장
		ctxPath = request.getContextPath();
		int beginIndex = ctxPath.length() + "/saram/".length();
		String path = reqUri.substring(beginIndex);
		path = path.substring(0, path.lastIndexOf("."));
		context.log(">>>>> path : " + path);
		request.setAttribute("path", path);
		
		String prefix = "/WEB-INF/jsp/";
		String suffix = ".jsp";
		String viewName = "form";
		boolean isRedirext = false;
		
		switch(path){
		case "list" : viewName = "list"; break;
		case "input" : viewName = "form"; break;
		default: System.out.println("해당 없음"); viewName = "list";
		}
		
		if(isRedirext){
			response.sendRedirect(ctxPath + "/" + viewName);
		}else{
			viewName = prefix + viewName + suffix;
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form에서 넘겨져 오는 데이터
	}
}