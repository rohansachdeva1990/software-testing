package com.rohan.mockito.bo.exception;

import java.sql.SQLException;

public class BOException extends Exception {

	private static final long serialVersionUID = 1L;

	public BOException(SQLException e) {
		super(e);
	}

	public BOException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
}
