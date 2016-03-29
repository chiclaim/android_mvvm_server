package com.web.mvvm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.mvvm.utils.ResponseJsonUtils;

/**
 * Servlet implementation class HostsServlet
 */
@WebServlet("/hosts")
public class HostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<String> urls = Arrays.asList("http://www.baidu.com/", "http://www.google.com/", "https://www.bing.com/");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResponseJsonUtils.json(response, urls);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
