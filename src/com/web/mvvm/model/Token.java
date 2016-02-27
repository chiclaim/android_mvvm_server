package com.web.mvvm.model;

public class Token {
	
	private String token;
	private long createTime;
	private long validPeriod;
	
	
	public Token(String token, long createTime, long validPeriod) {
		super();
		this.token = token;
		this.createTime = createTime;
		this.validPeriod = validPeriod;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getValidPeriod() {
		return validPeriod;
	}
	public void setValidPeriod(long validPeriod) {
		this.validPeriod = validPeriod;
	}
	
	
	

}
