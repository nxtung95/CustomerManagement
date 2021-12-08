package customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "category")
@Data
public class Category {
	@Id
	private String id;
	private String name;

	@DBRef
	private List<Product> productList;
}
