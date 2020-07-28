package org.comstudy21.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/login_form.jsp";
		
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}
	
	@Override
	// 사용자가 입력해서 전달 받은 것.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// Encoding 하고 나서 작성
		
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		System.out.println("userId : " + userId);
		System.out.println("passwd : " + passwd);
		
		System.out.println("address : " + address);
		System.out.println("email : " + email);
		System.out.println("tel : " + tel);
		
		PrintWriter out = response.getWriter();
		String path = request.getContextPath() + "/login2.do";
		out.println("<a href="+path+"?id="+userId+"&pw="+passwd+">login2</a>");
	}

}