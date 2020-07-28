package org.comstudy21.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailCommand implements Command {

	@Override
	public Resolve action(HttpServletRequest req, HttpServletResponse resp) {

		return new Resolve(false, "detail");
	}

}
