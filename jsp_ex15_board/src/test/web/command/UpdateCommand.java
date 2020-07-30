package test.web.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.model.BoardDao;
import test.web.model.BoardDto;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("UpdateCommand 호출");
		
		BoardDao dao = BoardDao.getInstance();
		ArrayList<BoardDto> updatelist = dao.list();
		System.out.println("updatelist.size() => " + updatelist.size());
		req.setAttribute("updatelist", updatelist);

	}
}
