package com.web.mvvm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContributorServlet
 */
@WebServlet("/contributor/list")
public class ContributorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		boolean valid = TokenServlet.checkTokenValid(TokenServlet.getRemortIP(request));
		if (!valid) {
			// code=401 and write to response
			// response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "invalid
			// token");
			
			response.setStatus(401);
			response.getWriter().append("access denied (jwt token is absent or invalid)");
			return;
			
			// ResponseJsonUtils.json(response, new RequestError(401, "invalid
			// token"));
			// return;
		}
		
		response.getWriter().append(readJson());
		//response.getWriter().append("invalid json format");
	}

	private String readJson() throws IOException {
		InputStream in = ContributorServlet.class.getResource("json").openStream();
		byte[] buffer = new byte[1024 * 4];
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		int len;
		while ((len = in.read(buffer)) != -1) {
			bao.write(buffer, 0, len);
			bao.flush();
		}
		in.close();
		String json = new String(bao.toByteArray());
		return json;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
