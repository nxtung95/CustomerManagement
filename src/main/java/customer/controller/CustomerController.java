package customer.controller;

import customer.dao.CustomerDao;
import customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/app")
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;

	@RequestMapping(value = "/manager/customer", method = RequestMethod.GET)
	public String index(Model model) {
		List<Customer> customerList = customerDao.search(null, null);
		model.addAttribute("customerList", customerList);
		return "customer/dashboard";
	}
}
