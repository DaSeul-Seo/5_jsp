package org.comstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsController implements Controller {

	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		String path = mkPath(req, resp);
		String viewName = "bbs/list";
		
		if("list".equals(path)){
			viewName = "bbs/list";
		} else if("home".equals(path)){
			viewName="home";
		} else if("board".equals(path)){
			viewName="bbs/board";
		}
		
		return new ModelAndView(viewName);
	}
}
