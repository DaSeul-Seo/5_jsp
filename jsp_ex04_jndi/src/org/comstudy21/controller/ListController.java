package org.comstudy21.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dto.Person;

public class ListController extends HttpServlet {
	
	private ArrayList<Person> pList = new ArrayList<>();
	{
		pList.add(new Person("Kim","서울특별시",20));
		pList.add(new Person("Lee","대전광역시",20));
		pList.add(new Person("Park","인천광역시",20));
		pList.add(new Person("Kang","부산광역시",20));
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("doGet - ListController");	
		
		req.setAttribute("p_List", pList);
		
		String path = "/WEB-INF/jsp/list.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		// req는 주소가 바뀌면 사라진다.
		// application 톰캣이 꺼지기 전까지는 살아있다.
		view.forward(req, resp);
	}
}