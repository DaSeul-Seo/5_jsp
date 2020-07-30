package org.comstudy21;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		try {
			getJspContext().getOut().print("SimpleTag Example");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
