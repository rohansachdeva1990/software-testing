package com.rohan.mockito.bo;

import java.sql.SQLException;

import com.rohan.mockito.bo.exception.BOException;
import com.rohan.mockito.demo.order.dao.OrderDAO;
import com.rohan.mockito.demo.order.dto.Order;

public class OrderBOImpl implements OrderBO {

	private OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {

		boolean result = false;

		try {
			int count = getDao().create(order);
			if (count > 0) {
				result = true;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}

		return result;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {

		boolean result = false;

		try {
			Order order = getDao().read(id);
			if (null == order) {
				throw new BOException("Invalid order");
			}

			order.setStatus("cancelled");
			int count = getDao().update(order);
			if (count > 0) {
				result = true;
			}

		} catch (SQLException e) {
			throw new BOException(e);
		}

		return result;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		boolean result = false;

		try {
			if (dao.delete(id) > 0) {
				result = true;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}

		return result;
	}

	
	/**
	 * To demonstrate that we can have multiple when scenrio for the 
	 * same function.
	 */
	@Override
	public boolean customOrderOperation(int id) throws BOException {
		boolean result = false;

		try {
			Order order = getDao().read(id);
			order.setStatus("cancelled");
			int count = getDao().update(order);
			if (count > 0) {
				count = getDao().update(order);
				if (count == 0) {
					result = true;
				}
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}

		return result;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}
}
