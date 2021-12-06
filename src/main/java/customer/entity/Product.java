//package customer.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "product")
//@Data
//public class Product {
//	@Id
//	private Integer id;
//	private String name;
//	private BigDecimal price;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "category_id", referencedColumnName = "id")
//	private Category category;
//}
