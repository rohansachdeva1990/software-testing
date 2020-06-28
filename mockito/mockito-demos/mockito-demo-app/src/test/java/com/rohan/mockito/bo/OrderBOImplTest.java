package com.rohan.mockito.bo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rohan.mockito.bo.exception.BOException;
import com.rohan.mockito.demo.order.dao.OrderDAO;
import com.rohan.mockito.demo.order.dto.Order;

public class OrderBOImplTest {

	// Step 1: Mocked the dependent class
	@Mock
	private OrderDAO dao;

	private OrderBOImpl bo;

	@Before
	public void setup() {
		/**
		 * This will scan through all the objects in the class marked by
		 * 
		 * @Mock annotation. It will create the proxy (mocked out) object for
		 *       this dao.
		 */

		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	// Positive Scenario
	@Test
	public void placeOrderShouldCreateAnOrder() throws SQLException, BOException {
		// Step 2: Set the expectation
		// To mock out the method call
		//Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(new Integer(1));

		// Step 3: Assert the results and Verify
		boolean result = bo.placeOrder(any(Order.class));

		// If result is true, then test case is successful.
		assertTrue(result);

		// To check if our mocked object is called once.
		verify(dao).create(any(Order.class));
	}

	// Negative Scenario
	@Test
	public void placeOrderShouldNotCreateAnOrder() throws SQLException, BOException {
		// Step 2: Set the expectation
		// To mock out the method call
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));

		// Step 3: Assert the results and Verify
		boolean result = bo.placeOrder(order);

		// If result is true, then test case is successful.
		assertFalse(result);

		// To check if our mocked object is called once.
		verify(dao).create(order);
	}

	// Exception Scenario
	@Test(expected = BOException.class)
	@SuppressWarnings("unchecked")
	public void placeOrderShouldThrowBOException() throws SQLException, BOException {
		// Step 2: Set the expectation
		// To mock out the method call
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		bo.placeOrder(order);
	}

	// Positive scenario
	@Test
	public void cancelOrderShouldCancelTheOrder() throws SQLException, BOException {
		Order order = new Order();

		// Setting the expectations
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(Integer.valueOf(1));

		// Calling method under test
		boolean result = bo.cancelOrder(123);

		// Verifying the results
		assertTrue(result);
		verify(dao).read(123);
		verify(dao).update(order);
	}

	// Negative scenario
	@Test
	public void cancelOrderShouldNotCancelTheOrder() throws SQLException, BOException {
		Order order = new Order();

		// Setting the expectations
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(Integer.valueOf(0));

		// Calling method under test
		boolean result = bo.cancelOrder(123);

		// Verifying the results
		assertFalse(result);
		verify(dao).read(123);
		verify(dao).update(order);
	}

	@Test(expected = BOException.class)
	public void cancelOrderShouldThrowBOExceptionWhenOrderReadNull() throws SQLException, BOException {
		when(dao.read(123)).thenReturn(null);
		bo.cancelOrder(123);
	}

	// Exception Scenario
	@Test(expected = BOException.class)
	@SuppressWarnings("unchecked")
	public void cancelOrderShouldThrowBOExceptionOnRead() throws SQLException, BOException {
		// Setting the expectations
		when(dao.read(123)).thenThrow(SQLException.class);
		// Calling method under test
		bo.cancelOrder(123);

	}

	// Exception Scenario
	@Test(expected = BOException.class)
	@SuppressWarnings("unchecked")
	public void cancelOrderShouldThrowBOExceptionOnUpdate() throws SQLException, BOException {
		Order order = new Order();
		// Setting the expectations
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);

		// Calling method under test
		bo.cancelOrder(123);
	}

	/**
	 * This example demonstrates how to set the expected value of consecutive
	 * function calls.
	 */
	@Test
	public void customOrderOperationShouldWork() throws SQLException, BOException {
		Order order = new Order();

		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1, 0);
		// or when(dao.update(order)).thenReturn(1).thenReturn(0);

		// Calling method under test
		boolean result = bo.customOrderOperation(123);

		// Verifying the results
		assertTrue(result);
		verify(dao).read(123);
		verify(dao, Mockito.atMost(2)).update(order);
	}

	@Test
	public void deleteOrderShouldRemoveAnOrder() throws SQLException, BOException {
		when(dao.delete(123)).thenReturn(1);
		boolean result = bo.deleteOrder(123);
		assertTrue(result);
		verify(dao).delete(123);
	}

	@Test
	public void deleteOrderShouldNotRemoveAnOrder() throws SQLException, BOException {
		when(dao.delete(anyInt())).thenReturn(0);
		boolean result = bo.deleteOrder(anyInt());
		assertFalse(result);
		verify(dao).delete(anyInt());
	}

	@Test(expected = BOException.class)
	@SuppressWarnings("unchecked")
	public void deleteOrderShouldThrowBOException() throws SQLException, BOException {
		when(dao.delete(123)).thenThrow(SQLException.class);
		bo.deleteOrder(123);
	}
}
