//package customer.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "invoice")
//@Data
//public class Invoice {
//	@Id
//	private Integer id;
//
//	@Column(name = "invoice_no")
//	private String invoiceNo;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "sale_date")
//	private Date saleDate;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "customer_id", referencedColumnName = "id")
//	private Customer customer;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "employee_id", referencedColumnName = "user_id")
//	private Employee employee;
//}
