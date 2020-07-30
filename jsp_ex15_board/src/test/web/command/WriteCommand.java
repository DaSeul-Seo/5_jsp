package test.web.command;

import javax.servlet.http.*;

import test.web.model.*;

public class WriteCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("WriteCommand 호출");
		
		String author = req.getParameter("author");
		String email = req.getParameter("email");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String passwd = req.getParameter("passwd");
		
		BoardDto data = new BoardDto(0, author, email, title, content, passwd, null, 0, 0, 0, 0);
//		data.setAuthor(author);
//		data.setEmail(email);
//		data.setTitle(title);
//		data.setContent(content);
//		data.setPasswd(passwd);
		
		BoardDao dao = BoardDao.getInstance();
//		data.setNum(dao.getNewPrimaryKey());
		dao.insert(data);
	}
}
