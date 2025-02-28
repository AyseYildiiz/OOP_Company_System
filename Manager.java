//This class is a template for creating managers.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Employee {
	//Data fields
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();//regular employees working in manager's department
	private double bonusBudget;
	//Constructor
	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department);
		if (bonusBudget <= 0)
			throw new Exception("Bonus budget cannot be negative");
		this.bonusBudget = bonusBudget;
	}
	//Constructor
	public Manager(Employee employee, double bonusBudget) throws Exception {
		super(employee, employee.getSalary(), employee.getHireDate(),employee.getDepartment());
		if (bonusBudget <= 0)
			throw new Exception("Bonus budget cannot be negative");
		this.bonusBudget = bonusBudget;
	}
	//Methods for organising regularEmployees list
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);

	}
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);

	}
	//Distributes bonus budget to regular employees
	public void distributeBonusBudget() throws Exception {
		double total=0;

		for (int i = 0 ; i <regularEmployees.size(); i++) {
			total += regularEmployees.get(i).getSalary()* regularEmployees.get(i).getPerformanceScore();
		}		

		double unit = this.bonusBudget / total;
		for (int i = 0 ; i <regularEmployees.size(); i++) {
			RegularEmployee a= regularEmployees.get(i);
			a.setBonus(unit*a.getSalary()*a.getPerformanceScore());
		}
	}
	//Getter setter methods 
	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}
	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}
	public double getBonusBudget() {
		return bonusBudget;
	}
	public void setBonusBudget(double bonusBudget) throws Exception {
		if (bonusBudget < 0)
			throw new Exception("Bonus budget cannot be negative");
		this.bonusBudget = bonusBudget;
	}
	@Override
	public String toString() {
		return "Manager [id=" + getId() + ", " + getFirstName()+" "+ getLastName() + "\n\t\t# of Employees:"+getRegularEmployees().size()+"]";
	}

}
