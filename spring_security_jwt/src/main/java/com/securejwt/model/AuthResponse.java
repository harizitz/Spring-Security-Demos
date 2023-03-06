package com.securejwt.model;

public class AuthResponse {

	private String Jwtstring;

	public String getJwtstring() {
		return Jwtstring;
	}

	public void setJwtstring(String jwtstring) {
		Jwtstring = jwtstring;
	}

	public AuthResponse(String jwtstring) {
		super();
		Jwtstring = jwtstring;
	}

}
