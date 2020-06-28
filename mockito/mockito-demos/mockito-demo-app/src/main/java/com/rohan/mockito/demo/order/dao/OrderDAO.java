package com.rohan.mockito.demo.order.dao;

import java.sql.SQLException;

import com.rohan.mockito.demo.order.dto.Order;

public interface OrderDAO {

	public int create(Order order) throws SQLException;

	public Order read(int id) throws SQLException;

	public int update(Order order) throws SQLException;

	public int delete(int Id) throws SQLException;
}
