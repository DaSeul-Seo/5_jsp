package test.web.command;

import java.util.ArrayList;

import javax.servlet.http.*;

import test.web.model.*;

public class ListCommand implements Command {
	/* (non-Javadoc)
	 * @see test.web.command.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("ListCommand 호출");
		
		BoardDao dao = BoardDao.getInstance();
		ArrayList<BoardDto> list = dao.list();
		System.out.println("list.size() => " + list.size());
		req.setAttribute("list", list);
	}
}
