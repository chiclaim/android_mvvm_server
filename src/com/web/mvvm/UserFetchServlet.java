package com.web.mvvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.mvvm.model.User;
import com.web.mvvm.utils.ResponseJsonUtils;

/**
 * Servlet implementation class HostsServlet
 */
@WebServlet("/user/fetch")
public class UserFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null && !"".equals(id.trim())) {
			ResponseJsonUtils.json(response, findUserById(id));
		} else {
			User user = new User(1, "chiclaim", "123@163.com");
			user.setFriends(getFriends());
			ResponseJsonUtils.json(response, user);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	User findUserById(String id) {
		return new User(Integer.parseInt(id), "Apple" + id, id + "@163.com");
	}

	private List<User> getFriends() {
		List<User> friends = new ArrayList<User>();
		for (int i = 1; i < 5; i++) {
			friends.add(new User(i));
		}
		return friends;
	}
}
