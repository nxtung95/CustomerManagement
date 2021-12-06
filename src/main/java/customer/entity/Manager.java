package customer.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "admin")
@Data
public class Manager extends User {
	@Field(name = "manager_id")
	private String managerId;
}
