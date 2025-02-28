//This class is a template for creating departments.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;

public class Department {
	//Data fields
	private int departmentId;
	private String departmentName;
	public static ArrayList<Department> depList = new ArrayList<Department>();//Shows all departments
	//Constructor
	public Department(int departmentId, String departmentName) throws Exception {
		setDepartmentId(departmentId);
		setDepartmentName(departmentName);
	}
	//Getter setter methods
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) throws Exception {
		if (departmentId <= 0) {
			throw new Exception("Department ID must be positive");
		}
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) throws Exception {
		if (departmentName == null) {
			throw new Exception("Department name cannot be blank");
		}
		if (departmentName.length() < 3) {
			throw new Exception("Department name must be at least 3 characters long");
		}
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";

	}

}
