//This class is a template for creating employees and the superclass of Manager and RegularEmployee classes.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee extends Person {
	//Data fields
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public static int numberofEmployees;	
	//Constructor
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department) throws Exception {
		super(id, firstName, lastName,gender, birthDate, maritalStatus, hasDriverLicence);
		if (salary <= 0)
			throw new Exception("Salary cannot be negative");
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees +=1;
	}
	//Constructor
	public Employee(Person person, double salary, Calendar hireDate, Department 
			department) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(),person.getGender(),
				person.getBirthDate(), person.getMaritalStatus() ,person.getHasDriverLicence());
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees +=1;
	}
	//Methods for arranging salary
	public double raiseSalary(double percent) {
		this.salary+=percent*salary;
		return salary;

	}
	public double raiseSalary(int amount) {
		this.salary += amount;
		return salary;

	}
	//Getter setter methods
	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) throws Exception {
		if (salary <= 0)
			throw new Exception("Salary must be positive");
		this.salary = salary;
	}

	public java.util.Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public static int getNumberofEmployees() {
		return numberofEmployees;
	}

	public static void setNumberofEmployees(int numberofEmployees) {
		Employee.numberofEmployees = numberofEmployees;
	}

	@Override
	public String toString() {
		return "Person Info [id=" + getId() + ", firstName=" + getFirstName() + ", lastName="+ getLastName()+ ", gender=" + getGender()+"]"+"\n\t\t\t\tEmployee Info [salary=" + getSalary() + ", hireDate=" +((GregorianCalendar)hireDate).get(Calendar.DATE) +"/"+((GregorianCalendar)hireDate).get(Calendar.MONTH)+"/"+((GregorianCalendar)hireDate).get(Calendar.YEAR)+ "] \n";

	}

}
