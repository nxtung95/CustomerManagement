package customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "invoice")
@Data
public class Invoice {
	@Id
	private String id;

	@Field(name = "invoice_no")
	private String invoiceNo;

	@Field(name = "sale_date")
	private String saleDate;

	@DBRef
	@Field(name = "detail_invoice_list")
	private List<DetailInvoice> detailInvoiceList;
}
