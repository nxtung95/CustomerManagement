package customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "admin")
@Data
public class Manager {
	@Id
	private String id;
	@Field(name = "user_id")
	private String userId;
	@Field(name = "manager_id")
	private String managerId;
}
