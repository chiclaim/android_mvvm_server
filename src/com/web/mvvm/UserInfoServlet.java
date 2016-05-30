package com.web.mvvm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean valid = TokenServlet.checkTokenValid(TokenServlet.getRemortIP(request));
		String p = request.getParameter("noToken");
		if (!"1".equals(p)) {
			if (!valid) {
				// code=401 and write to response
				// response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				// "invalid
				// token");

				response.setStatus(401);
				response.getWriter().append("access denied (jwt token is absent or invalid)");
				return;
			}
			// ResponseJsonUtils.json(response, new RequestError(401, "invalid
			// token"));
			// return;
		} else {
			response.getWriter().append("username:chiclaim,age:007");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
