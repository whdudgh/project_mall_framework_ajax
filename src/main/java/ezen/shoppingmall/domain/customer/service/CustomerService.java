package ezen.shoppingmall.domain.customer.service;

import java.util.List;

import ezen.shoppingmall.domain.customer.dto.Customer;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리를 위한 명세
 */
public interface CustomerService {
	/** 회원 등록 */
	public Customer registerCustomer(Customer customer);
	/** 회원 인증 */
	public Customer isCustomer(String email, String uPwd);
	/** 회원 전체 목록 */
	public List<Customer> getCustomers();
	/** 회원 상세정보 조회 */
	public Customer readCustomer(String email);
}
