//This class is a template for creating regular employees and the superclass of SalesEmployee and Developer classes.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;

public class RegularEmployee extends Employee {
	//Data fields
	private double performanceScore;
	private double bonus ;
	//Constructor
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double performanceScore) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department);
		if (performanceScore < 0)
			throw new Exception("Performance score cannot be negative");
		this.performanceScore = performanceScore;
	}
	//Constructor
	public RegularEmployee (Employee employee, double perfScore) throws Exception {
		super(employee, employee.getSalary(), employee.getHireDate(),employee.getDepartment());
		if (performanceScore < 0)
			throw new Exception("Performance score cannot be negative");
		this.performanceScore = perfScore;
	}
	//Getter setter methods
	public double getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(double performanceScore) throws Exception {
		if (performanceScore <= 0)
			throw new Exception("Performance score cannot be negative");
		this.performanceScore = performanceScore;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) throws Exception {
		if (bonus <= 0)
			throw new Exception("Bonus cannot be negative");
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString()+"\t\t\t\tRegularEmployee Info [performanceScore=" + performanceScore + ", bonus=" + bonus + "]\n";
	}

}
