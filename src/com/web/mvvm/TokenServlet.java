package com.web.mvvm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.mvvm.model.Token;
import com.web.mvvm.utils.ResponseJsonUtils;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/token")
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Token的有效期为10s
	public static final long TOKEN_VALID_TIME = 1000 * 10L;

	// 不应该是static 方便测试。。。
	public static Map<String, Token> tokens = new HashMap<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String ip = getRemortIP(request);
		Token token = tokens.get(ip);
		if (token == null || !checkTokenValid(token.getToken())) {
			token = new Token(UUID.randomUUID().toString(), System.currentTimeMillis(), TOKEN_VALID_TIME);
			tokens.put(ip, token);
		}
		ResponseJsonUtils.json(response, token);
	}

	/**
	 * 获取ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

	/**
	 * 判断token是否有效
	 * 
	 * @param tokenValue
	 * @return 无效返回false，反之返回true
	 */
	public static boolean checkTokenValid(String tokenValue) {
		Token token = tokens.get(tokenValue);
		if (token == null) {
			return false;
		}
		if (System.currentTimeMillis() - token.getCreateTime() >= token.getValidPeriod()) {
			return false;
		}
		return true;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
