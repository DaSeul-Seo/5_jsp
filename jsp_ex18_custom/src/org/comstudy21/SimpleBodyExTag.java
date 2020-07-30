package org.comstudy21;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleBodyExTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		try {
			getJspContext().setAttribute("message", "body에 표현식 예제");
			
			// null이면 다른 Writer가 아닌 response로 JSP의 body내용을 전달
			getJspBody().invoke(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
