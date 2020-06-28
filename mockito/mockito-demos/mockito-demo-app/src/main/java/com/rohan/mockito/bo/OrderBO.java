package com.rohan.mockito.bo;

import com.rohan.mockito.bo.exception.BOException;
import com.rohan.mockito.demo.order.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;
	
	boolean customOrderOperation(int id) throws BOException;
}
