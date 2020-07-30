package test.web.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.model.BoardDao;
import test.web.model.BoardDto;

public class DetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("DetailCommand 호출");

		int num = Integer.parseInt(req.getParameter("num"));
//		String author = req.getParameter("author");
//		String email = req.getParameter("email");
//		String content = req.getParameter("content");
//		String passwd = req.getParameter("passwd");
		
		BoardDto dto = new BoardDto(num, null, null, null, null, null, null, 0, 0, 0, 0);
		
		BoardDao dao = BoardDao.getInstance();
		ArrayList<BoardDto> detaillist = dao.selectOne(dto);
		System.out.println("detaillist.size() => " + detaillist.size());
		req.setAttribute("detaillist", detaillist);
	}
}
