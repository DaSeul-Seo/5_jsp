package org.comstudy21.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodeFilter implements Filter{
	ServletContext context;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		context = config.getServletContext();
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 형변환
		HttpServletRequest request = (HttpServletRequest)req;
		// request filter
		context.log("request filter");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		req.setAttribute("prefix", "/WEB-INF/views");
		req.setAttribute("suffix", ".jsp");
		String contextPath = request.getContextPath();
		String reqUri = request.getRequestURI();
		int beginIndex = contextPath.length() + 1;
		int endIndex = reqUri.lastIndexOf(".");
		String path = reqUri.substring(beginIndex, endIndex);
		req.setAttribute("path", path);
		
		// chain 기준
		chain.doFilter(req, resp);
		// response filter
		context.log("response filter");
	}
	
	@Override
	public void destroy() {}
	
}
