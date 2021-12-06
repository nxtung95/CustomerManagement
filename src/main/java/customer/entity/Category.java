//package customer.entity;
//
//import lombok.Data;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Document(collection = "category")
//@Data
//public class Category {
//	@Id
//	private Integer id;
//
//	private String name;
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//	private Set<Product> products;
//}
