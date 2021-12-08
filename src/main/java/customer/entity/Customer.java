package customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "customer")
@Data
public class Customer {
	@Id
	private String id;
	private String name;
	private String address;

	@Field(name = "represent_name")
	private String representName;

	@DBRef
	@Field(name = "invoice_list")
	private List<Invoice> invoiceList;
}
