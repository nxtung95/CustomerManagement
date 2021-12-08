package customer.dao;

import customer.dto.CustomerDto;
import customer.entity.Customer;
import customer.entity.DetailInvoice;
import customer.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<CustomerDto> search(String name, String presentName) {
		Query query = new Query();
		if (name != null && name != "") {
			query.addCriteria(Criteria.where("name").regex(name));
		}
		if (presentName != null && presentName != "") {
			query.addCriteria(Criteria.where("represent_name").regex(presentName));
		}
		List<Customer> customers = mongoTemplate.find(query, Customer.class);
		List<CustomerDto> customerList = new ArrayList<>();
		for (Customer c : customers) {
			String companyName = c.getName();
			String address = c.getAddress();
			String representName = c.getRepresentName();
			int totalPrice = 0;
			List<Invoice> invoiceList = c.getInvoiceList();
			for (Invoice i : invoiceList) {
				List<DetailInvoice> detailInvoiceList = i.getDetailInvoiceList();
				for (DetailInvoice di : detailInvoiceList) {
					totalPrice += di.getPrice() * di.getQuantity();
				}
			}
			customerList.add(new CustomerDto(c.getId(), companyName, address, representName, totalPrice));
		}
		return customerList;
	}

	public boolean update(Customer newCus) {
		Customer customer = mongoTemplate.findOne(Query.query(Criteria.where("id").is(newCus.getId())), Customer.class);
		if (customer != null) {
			customer.setId(newCus.getId());
			customer.setName(newCus.getName());
			customer.setAddress(newCus.getAddress());
			customer.setRepresentName(newCus.getRepresentName());
			mongoTemplate.save(customer);
			return true;
		}
		return false;
	}

	public boolean add(Customer c) {
		Customer customer = mongoTemplate.save(c);
		if (customer != null) {
			return true;
		}
		return false;
	}

	public boolean remove(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query);
		return true;
	}
}
