package ezen.shoppingmall.domain.common.factory;

import ezen.shoppingmall.domain.board.dao.ArticleDao;
import ezen.shoppingmall.domain.board.dao.JdbcArticleDao;
import ezen.shoppingmall.domain.cart.dao.CartDao;
import ezen.shoppingmall.domain.cart.dao.JdbcCartDao;
import ezen.shoppingmall.domain.customer.dao.CustomerDao;
import ezen.shoppingmall.domain.customer.dao.JdbcCustomerDao;
import ezen.shoppingmall.domain.product.dao.ProductDao;
import ezen.shoppingmall.domain.product.dao.jdbcProductDao;
import ezen.shoppingmall.domain.total_order.dao.TotalOrderDao;
import ezen.shoppingmall.domain.total_order.dao.jdbcTotalOrderDao;

/**
 * Simple Factory 적용
 */
public class DaoFactory {

	private static DaoFactory instance = new DaoFactory();

	private DaoFactory() {}

	public static DaoFactory getInstance() {
		return instance;
	}

	
	// ArticleDao 구현체 반환
	public ArticleDao getArticleDao() {
		return new JdbcArticleDao();
	}
	
	public ProductDao getProductDao() {
		return new jdbcProductDao();
	}
	
	public CartDao getCartDao() {
		return new JdbcCartDao();
	}
	
	// TotalOrderDao 구현체 반환
	public TotalOrderDao getTotalOrderDao() {
		return new jdbcTotalOrderDao();
	}
	
	public CustomerDao getCustomerDao() {
		return new JdbcCustomerDao();
	}

}
