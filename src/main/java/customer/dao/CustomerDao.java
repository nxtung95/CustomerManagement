package customer.dao;

import customer.entity.Customer;
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

	public List<Customer> search(String name, String date) {
		List<Customer> customers;
		Query query = new Query();
		if (name != null && name != "") {
			query.addCriteria(Criteria.where("name").regex(name));
		}
		if (date != null && date != "") {
			query.addCriteria(Criteria.where("birthday").regex(date));
		}
		customers = mongoTemplate.find(query, Customer.class);
		return customers;
	}
}
