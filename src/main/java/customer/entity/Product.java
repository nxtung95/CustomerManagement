package customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "product")
@Data
public class Product {
	@Id
	private String id;
	private String name;
	private String price;

	@DBRef
	@Field(name = "detail_invoice_list")
	private List<DetailInvoice> detailInvoiceList;
}
