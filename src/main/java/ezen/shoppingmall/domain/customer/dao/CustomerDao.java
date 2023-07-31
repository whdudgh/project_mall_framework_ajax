package ezen.shoppingmall.domain.customer.dao;

import java.sql.Connection;
import java.util.List;

import ezen.shoppingmall.domain.customer.dto.Customer;

/**
 * 데이터 베이스 고객 관리 명세
 *
 */
public interface CustomerDao {
   
   //커스터머생성
   public boolean create(Connection connection,  Customer customer);
   public Customer findByUser(Connection connection, String email, String uPwd);
   public List<Customer> findByAll(Connection connection);
   public Customer findByEmail(Connection connection, String email);
   
}