package ezen.shoppingmall.web.work.customer.controller;

import java.util.List;
import java.util.Map;

import ezen.shoppingmall.domain.common.factory.DaoFactory;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.customer.service.CustomerService;
import ezen.shoppingmall.web.mvc.controller.WebController;

/**
 * 회원 목록 요청 처리 세부 컨트롤러
 * /customer
 */
public class CustomerListController implements WebController{
	
	private CustomerService customerService = ServiceFactory.getInstance().getCustomerService();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "customer/customers";
		
		List<Customer> customers = customerService.getCustomers();
		model.put("customers", customers);
		return viewName;
	}

}













