package ezen.shoppingmall.domain.common.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import ezen.shoppingmall.domain.cart.service.CartService;
import ezen.shoppingmall.domain.cart.service.CartServiceImpl;
import ezen.shoppingmall.domain.customer.service.CustomerService;
import ezen.shoppingmall.domain.customer.service.CustomerServiceImpl;
import ezen.shoppingmall.domain.product.service.ProductService;
import ezen.shoppingmall.domain.product.service.ProductServiceImpl;
import ezen.shoppingmall.domain.total_order.service.TotalOrderService;
import ezen.shoppingmall.domain.total_order.service.TotalOrderServiceImpl;

/**
 * 서비스(비즈니스) 객체 생성 및 의존관계 설정
 * 도메인(업무영역)별 객체 생성 및 조립 역할 (조립자) 
 * 싱글톤 패턴 적용
 * @author 김기정
 */
public class ServiceFactory {
	private static ServiceFactory instance = new ServiceFactory();
	
	private DataSource dataSource;
	private DaoFactory daoFactory = DaoFactory.getInstance();

	private String driver;
	private String url;
	private String username;
	private String password;
	
	private ServiceFactory() {
		loadProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);      // 풀의 초기 커넥션 개수
		dataSource.setMaxTotal(10);        // 최대 커넥션 개수
		dataSource.setMaxIdle(5);          // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		dataSource.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		this.dataSource = dataSource;
	}
	
	private void loadProperties() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		try {
			prop.load(in);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.username = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	
	// 도메인(업무영역)별 xxxxService 객체 생성 및 반환
	// 상품관련 서비스객체
	public ProductService getProductService() {
		return new ProductServiceImpl(dataSource, daoFactory.getProductDao());
	}
	// 카트관련 서비스객체
	public CartService getCartService() {
		return new CartServiceImpl(dataSource, daoFactory.getCartDao());
	}
	
	// 주문관련 서비스객체
	public TotalOrderService getTotalOrderService() {
		return new TotalOrderServiceImpl(dataSource, daoFactory.getTotalOrderDao());
	}
	
	public CustomerService getCustomerService() {
		return new CustomerServiceImpl(dataSource, daoFactory.getCustomerDao());
	}
}
