package com.asama.springbootsecurity.domain;

public class LoginResponse {

	private String accessToken;
	private String tokenType = "Bearer";
	private String userName;

	public LoginResponse(String accessToken, String userName) {
		super();
		this.accessToken = accessToken;
		this.userName = userName;
	}

	public LoginResponse() {
		super();
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
