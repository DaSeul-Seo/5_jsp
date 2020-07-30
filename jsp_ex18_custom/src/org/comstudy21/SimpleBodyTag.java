package org.comstudy21;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleBodyTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		try {
			getJspContext().getOut().write("Hong!");
			
			// null이면 다른 Writer가 아닌 response로 JSP의 body내용을 전달한다.
			getJspBody().invoke(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
