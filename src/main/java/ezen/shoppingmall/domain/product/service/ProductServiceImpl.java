package ezen.shoppingmall.domain.product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.product.dao.ProductDao;
import ezen.shoppingmall.domain.product.dto.Category;
import ezen.shoppingmall.domain.product.dto.Product;
import ezen.shoppingmall.web.common.page.PageParams;

/**
 * 상품 관련 비즈니스 로직 처리 및 트랜잭션 처리 구현체
 * 
 * @author 문승욱
 *
 */
public class ProductServiceImpl implements ProductService {

	private DataSource dataSource;
	private ProductDao productDao;

	public ProductServiceImpl(DataSource dataSource, ProductDao productDao) {
		this.dataSource = dataSource;
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProductList(String categoryName, PageParams params) {
		List<Product> list = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			list = productDao.findAllByProduct(connection, categoryName, params.getRequestPage(), params.getElementSize());
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
	public int getProductCount(String categoryKey) {
		int count = 0;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			count = productDao.getCountAll(connection, categoryKey);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e1) {
			}
		}
		return count;
	}
	

	@Override
	public List<Category> getCategorys() {
		List<Category> list = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			list = productDao.findCategries(connection);
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
	
	/**
	 * 상품이름에 해당하는 상품검색
	 */
	@Override
	public Product getProductByName(String pName) {
		Product product;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			
			product = productDao.findByName(connection, pName);
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)	connection.close();
			} catch (SQLException e1) {	}
		}
		return product;
	}

	
//	//테스트
//	public static void main(String[] args) {
//		ServiceFactory serviceFactory = ServiceFactory.getInstance();
//		ProductService productService = serviceFactory.getProductService();
//		PageParams param = new PageParams(4, 5, 5, 16);
//		List<Product> list = productService.getProductList("AQ", param);
//		for (Product product : list) {
//			System.out.println(product);
//		}
		
}
