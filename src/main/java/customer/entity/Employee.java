package customer.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employee")
@Data
public class Employee extends User {
	@Field("employee_id")
	private String employeeId;
	@Field("department")
	private String department;
}
