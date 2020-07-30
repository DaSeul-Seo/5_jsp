package test.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.command.Command;
import test.web.command.DetailCommand;
import test.web.command.ListCommand;
import test.web.command.UpdateCommand;
import test.web.command.WriteCommand;

@WebServlet(description = "board front controller", urlPatterns = { "/board" })
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FrontController 호출");
		// 파라미터(action) 넘겨서 값이 list는 list처리
		String action = req.getParameter("action");
		String viewName = "/WEB-INF/views/board/list.jsp";
		
		try {
			if(action.equals("list")){
				Command command = new ListCommand();
				command.execute(req, resp);
				viewName = "/WEB-INF/views/board/list.jsp";
			}
			else if(action.equals("write.ui")){
				viewName = "/WEB-INF/views/board/write.jsp";
			}
			else if(action.equals("write.do")){
				WriteCommand writecmd = new WriteCommand();
				writecmd.execute(req, resp);
				resp.sendRedirect("board?action=list");
			}
			else if(action.equals("detail.ui")){
				DetailCommand datailcmd = new DetailCommand();
				datailcmd.execute(req, resp);
				viewName = "/WEB-INF/views/board/detail.jsp";
			}
			else if(action.equals("update.ui")){
				viewName = "/WEB-INF/views/board/update.jsp";
			}
			else if(action.equals("update.do")){
				UpdateCommand updatecmd = new UpdateCommand();
				updatecmd.execute(req, resp);
				resp.sendRedirect("board?action=list");
				return;
			}

			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
