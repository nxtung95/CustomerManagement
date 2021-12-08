package customer.controller;

import customer.dao.CustomerDao;
import customer.dto.CustomerDto;
import customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/app")
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;

	@RequestMapping(value = "/manager/customer", method = RequestMethod.GET)
	public String index(Model model) {
		List<CustomerDto> customerList = new ArrayList<>();
		try {
			customerList = customerDao.search(null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("customerList", customerList);
		return "customer/dashboard";
	}

	@RequestMapping(value = "/manager/customer/search", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Map<String, Object> search(@RequestParam(name = "name") String name, @RequestParam(name = "representName") String representName) {
		Map<String, Object> result = new HashMap<>();
		List<CustomerDto> customerList = new ArrayList<>();
		try {
			customerList = customerDao.search(name, representName);
			result.put("status", "200");
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("customerList", customerList);
		return result;
	}

	@RequestMapping(value = "/manager/customer", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Map<String, Object> add(@RequestBody Map<String, Object> payload) {
		Map<String, Object> result = new HashMap<>();
		List<CustomerDto> customerList = new ArrayList<>();
		try {
			Customer customer = new Customer();
			customer.setName((String) payload.get("name"));
			customer.setRepresentName((String) payload.get("represent_name"));
			customer.setAddress((String) payload.get("address"));
			boolean add = customerDao.add(customer);
			if (add) {
				customerList = customerDao.search(null, null);
				result.put("status", "200");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("customerList", customerList);
		return result;
	}

	@RequestMapping(value = "/manager/customer/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Map<String, Object> edit(@PathVariable String id, @RequestBody Map<String, Object> payload) {
		Map<String, Object> result = new HashMap<>();
		List<CustomerDto> customerList = new ArrayList<>();
		try {
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName((String) payload.get("name"));
			customer.setRepresentName((String) payload.get("represent_name"));
			customer.setAddress((String) payload.get("address"));
			boolean update = customerDao.update(customer);
			if (update) {
				customerList = customerDao.search(null, null);
				result.put("status", "200");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("customerList", customerList);
		return result;
	}

	@RequestMapping(value = "/manager/customer/{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Map<String, Object> remove(@PathVariable String id, Model model) {
		Map<String, Object> result = new HashMap<>();
		List<CustomerDto> customerList = new ArrayList<>();
		try {
			boolean removed = customerDao.remove(id);
			if (removed) {
				customerList = customerDao.search(null, null);
				result.put("status", "200");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("customerList", customerList);
		return result;
	}
}
