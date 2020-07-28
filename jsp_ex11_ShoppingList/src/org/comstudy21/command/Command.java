package org.comstudy21.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	Resolve action(HttpServletRequest req, HttpServletResponse resp);
//	Resolve postAction(HttpServletRequest req, HttpServletResponse resp);
}
