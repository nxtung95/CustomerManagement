package customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "user")
@Data
public class User {
	@Id
	private String id;

	@Field(value = "username")
	private String username;
	@Field(value = "password")
	private String password;

	@Field(value = "name")
	private String name;

	@Field(value = "birthday")
	private String birthday;
	@Field(value = "address")
	private String address;

	@Field(value = "role")
	private String role;
}
