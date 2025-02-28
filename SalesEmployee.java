//This class is a template for creating sales employees.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
	//Data fields
	private ArrayList< Product> sales;//Contains a product list that the SalesEmployee sells
	public static int numberOfSalesEmployees;
	//Constructor
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double performanceScore, ArrayList<Product> s) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				performanceScore);
		this.sales = s;
		numberOfSalesEmployees+=1;
	}
	//Constructor
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) throws Exception{
		super(re, re.getPerformanceScore());
		this.sales = s;
		numberOfSalesEmployees+=1;
	}
	//Calculates the profit from the sales
	public double salesValue () {
		double salesValue = 0;
		for (Product p : getSales()) {
			salesValue += p.getPrice();	
		}
		return salesValue;
	}
	//Methods for arranging sales list
	public boolean addSale(Product s) {
		return sales.add(s);
	}
	public boolean removeSale(Product s) {
		return sales.remove(s);
	}
	//Getter setter methods
	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}

	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees;
	}

	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
	}

	@Override
	public String toString() {
		return super.toString() + "\t\t\t\t" + sales + "]";
	}

}
