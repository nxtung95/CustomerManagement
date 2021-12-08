package customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "detail_invoice")
public class DetailInvoice {
	@Id
	private String id;
	private int quantity;
	private Long price;

	@Field("product_name")
	private String productName;
}
