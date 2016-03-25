package com.web.mvvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.mvvm.utils.ResponseJsonUtils;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 6649497110388061333L;
	public List<String> results = Arrays.asList("Apple", "Blank", "Cheese", "Denstiny", "Eason", "Fuck", "Google",
			"Hoodoo", "JackWhaton", "Chiclaim", "Twitter", "Facebook", "Baidu", "Sohu", "Sina", "Qihu", "Tencent",
			"Alibaba", "Ebay", "Amazon", "Yahoo", "Microsoft");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		List<String> list = new ArrayList<>();
		for (String string : results) {
			if (string.contains(key)) {
				list.add(string);
			}
		}
		ResponseJsonUtils.json(resp, list);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
