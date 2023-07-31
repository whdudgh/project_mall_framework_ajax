package ezen.shoppingmall.web.work.customer.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.customer.dto.Customer;
import ezen.shoppingmall.domain.customer.service.CustomerService;
import ezen.shoppingmall.web.mvc.controller.HttpController;

/**
 * 회원 가입 화면 및 가입 요청 처리 세부 컨트롤러
 * /signup/complete
 */
public class CustomerSignupController implements HttpController {
	
	private CustomerService customerService =  ServiceFactory.getInstance().getCustomerService();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		String viewName = "customer/login";
//		// 회원 가입 화면 요청 (GET)
//		if(request.getMethod().equalsIgnoreCase("get")) {
//			viewName = "customer/login";
//		}else { // 회원 가입 요청 (POST)
//			viewName = "customer/login";
		    String method = request.getMethod();
			String name = paramMap.get("name");
			String fEmail = paramMap.get("fEmail");
			String bEmail = paramMap.get("bEmail");
			String passwd = paramMap.get("psw");
			String phonenumber = paramMap.get("phone");
			String birthday = paramMap.get("birthday");
			StringBuilder stb = new StringBuilder();
			String fullEamil = stb.append(fEmail).append("@").append(bEmail).toString().trim();
			System.out.println(fullEamil);
			System.out.println(method);
			//DB갔다와서 cust_key갖고와야함.

//			Customer customer = new Customer(name, fullEamil, passwd, phonenumber,  birthday);
			
//			// 반환받은 member 객체에는 가입일자 정보 포함
//			customer = customerService.registerCustomer(customer);
			// 모델에 회원정보 저장
//			model.put("customer", customer);
//		}
		return viewName;
	}
}










