package ezen.shoppingmall.web.work.customer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.customer.service.CustomerService;
import ezen.shoppingmall.web.mvc.controller.HttpController;

/**
 * 로그인체크 세부컨트롤러
 * @author USER
 *
 */
public class LoginStatusController implements HttpController{
	
	//private CustomerService customerService = ServiceFactory.getInstance().getCustomerService();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {

		String viewName = "customer/login-result";

		boolean reuslt = false;
		Customer customer = (Customer)request.getSession().getAttribute("loginCustomer");
		System.out.println(customer);

		if(customer != null) {
			reuslt = true;
		}
		
		model.put("reuslt", reuslt);

		return viewName;
	}

}
