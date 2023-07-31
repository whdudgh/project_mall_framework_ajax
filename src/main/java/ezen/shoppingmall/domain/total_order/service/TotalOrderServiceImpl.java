package ezen.shoppingmall.domain.total_order.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.product.dto.Product;
import ezen.shoppingmall.domain.total_order.dao.TotalOrderDao;

/**
 * 상품 관련 비즈니스 로직 처리 및 트랜잭션 처리 구현체
 * 
 * @author 장원종
 *
 */
public class TotalOrderServiceImpl implements TotalOrderService {

	private DataSource dataSource;
	private TotalOrderDao totalOrderDao;

	public TotalOrderServiceImpl(DataSource dataSource, TotalOrderDao totalOrderDao) {
		this.dataSource = dataSource;
		this.totalOrderDao = totalOrderDao;
	}

	@Override
	public List<Customer> getCostomer(int custKey) {
		List<Customer> list = null;

		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			list = totalOrderDao.findCustomerByCustKey(connection, custKey);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e1) {
			}
		}

		return list;
	}
	
	@Override
	public List<Product> getProduct(String productKey) {
		
		List<Product> list = null;

		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			list = totalOrderDao.findProductbyPKey(connection, productKey);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e1) {
			}
		}
		
		return list;
	}
	

//	public static void main(String[] args) {
//		ServiceFactory serviceFactory = ServiceFactory.getInstance();
//		TotalOrderService orderService = serviceFactory.getTotalOrderService();
//		List<Customer> list = orderService.getCostomer("jun1@gmail.com");
//		System.out.println(list);
//		for (Product product : list) {
//			System.out.println(product);
//		}
//	}

	

}
