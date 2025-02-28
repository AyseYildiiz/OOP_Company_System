//This class is a test class for implement other classes.
//Ayşe Yıldız ID: 150122015
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		try {
			//Reads input from a file 
			File infile = new File("input.txt") ;
			Scanner input = new Scanner(infile);
			//Prints output in a file
			File outfile = new File("output.txt");
			PrintWriter output = new PrintWriter(outfile);	
			//Creates an instance of test class to use non-static methods
			Test test = new Test();

			//Reads lines in input file and creates objects
			while(input.hasNext()) {
				String com = input.nextLine();
				test.createObject(com);

			}
			//Fills regularEmployees list
			fillRegEmpList();
			//Rearranges salary or bonus
			editSalaryBonus(test);
			//Prints all the output text
			printing(output);
			output.close();
			////Catches exceptions and prints suitable messages 
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("There is a problem: " + e.getMessage());
		}

	}
	//Prints all the output text
	public static void printing(PrintWriter output) {
		for (Department b : Department.depList ) {
			output.println("************************************************");
			output.println(b.toString());
			for (Person p : Person.personList) {
				if (p instanceof Manager && ((Manager)p).getDepartment().equals(b)) {

					output.println("\t"+p);
					for(RegularEmployee r: ((Manager)p).getRegularEmployees()) {
						if(r instanceof Developer) {
							output.println("\t\t\t1. Developer ");
							output.println("\t\t\t\t" + r);
						}
					}
					for(RegularEmployee r: ((Manager)p).getRegularEmployees()) {
						if (r instanceof SalesEmployee) {
							output.println("\t\t\t2. SalesEmployee ");
							output.println("\t\t\t\t" +r);
						}
					}
					for(RegularEmployee r: ((Manager)p).getRegularEmployees()) {
						if(!(r instanceof Developer ||r instanceof SalesEmployee)) {
							output.println("\t\t\t3. RegularEmployee \n\t\t\t\t"+r);
						} 

					}
				}
			}
		}
		output.println("\n\n\n*****************************CUSTOMERS*****************************");
		for(Person c : Person.personList) {
			if (c instanceof Customer) {
				output.println(((Customer)c));
			}
		}
		output.println();
		output.println("\n*****************************PEOPLE*****************************");
		for (Person p : Person.personList) {
			if (!(p instanceof Customer||p instanceof Employee))
				output.println(p);
		}
	}
	//Rearranges salary or bonus
	public static void editSalaryBonus(Test test) throws Exception {
		for (Person emp : Person.personList) {
			if (emp instanceof Manager) {
				Manager manager = (Manager) emp ;
				manager.distributeBonusBudget();
				manager.raiseSalary(0.2);
			}
			else if (emp instanceof SalesEmployee) {
				SalesEmployee salEmp = (SalesEmployee)emp ;
				salEmp.raiseSalary(0.18);
				if(salEmp.salesValue()==test.mostSale()) 
					salEmp.raiseSalary(10000);
			}
			else if (emp instanceof Developer) {
				Developer dev = (Developer)emp;
				dev.raiseSalary(0.23);
			}
			else if (emp instanceof RegularEmployee) {
				RegularEmployee regEmp = (RegularEmployee)emp;
				regEmp.raiseSalary(0.3);
			}
		}
	}
	//Fills regularEmployees list
	public static void fillRegEmpList() {
		for (Department a : Department.depList ) {
			for (Person p : Person.personList) {
				if (p instanceof Manager) {
					if (((Manager)p).getDepartment().equals(a)) {
						for (Person x : Person.personList) {
							if(x instanceof RegularEmployee && ((RegularEmployee)x).getDepartment().equals(a)) {
								((Manager)p).addEmployee((RegularEmployee)x);
							}
						}
					}
				}
			}
		}
	}
	//Creates object with the first words in the lines 
	public void createObject(String com) throws Exception {

		String [] words = com.split(" ");

		switch (words[0]) {
		case "Person":
			createPerson(words);
			break;
		case "Customer":
			createCustomer(words);
			break;
		case "Employee":
			createEmployee(words);
			break;
		case "Manager":
			createManager(words);
			break;
		case "RegularEmployee":
			createRegEmp(words);
			break;
		case "SalesEmployee":
			createSalEmp(words);
			break;
		case "Developer":
			createDev(words);
			break;
		case "Product":
			createProduct(words);
			break;
		case "Project":
			createProject(words);
			break;
		case "Department":
			createDepartment(words);
			break;
		}

	}
	//Creates Calendar object
	public Calendar getCal(String word) {
		String [] date=  word.split("/");
		return new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

	}
	//Creates Department and adds in department list
	public Department createDepartment (String [] words) throws Exception {
		Department department = new Department(Integer.parseInt(words[1]), words[2]);
		if(!Department.depList.contains(department))
			Department.depList.add(department);
		return department;
	}
	//Creates Project object and adds in project list
	public Project createProject (String [] words) throws Exception {
		Project project = new Project(words[1], getCal(words[2]),words[3]);
		if(!Project.allProjectList.contains(project))
			Project.allProjectList.add(project);
		return project;
	}
	//Creates Product object and adds in product list
	public Product createProduct (String [] words) throws Exception {
		Product product = new Product(words[1],getCal(words[2]), Integer.parseInt(words[3]));
		if(!Product.allProductList.contains(product))
			Product.allProductList.add(product);
		return product;
	}
	//Creates Person object and adds in person list
	public Person createPerson(String [] words) throws Exception {
		Person person = new Person(Integer.parseInt(words[3]),words[1] , words[2], words[4],getCal(words[5]),words[6], words[7]);
		if(!Person.personList.contains(person))
			Person.personList.add(person);
		return person;
	}
	//Creates Customer object and rearranges the person list
	public Customer createCustomer(String[] words) throws Exception {
		Person person = findPerson(words);
		ArrayList<Product> currentList = new ArrayList<>();
		for (int j = 2; j < words.length; j++) {
			for (Product product : Product.allProductList) {
				if (words[j].equals(product.getProductName())) {
					currentList.add(product);
					break;
				}
			}
		}
		Customer customer = new Customer(person, currentList);
		if (!Person.personList.contains(customer))
			Person.personList.add(customer);
		Person.personList.remove(person);
		return customer;
	}
	//Creates Employee object and rearranges the person list
	public Employee createEmployee(String [] words ) throws Exception {
		Person person = findPerson(words);
		Employee employee= new Employee(person, Integer.parseInt(words[2]),getCal(words[3]), findDepartment(words));
		if(!Person.personList.contains(employee)) {
			Person.personList.add(employee);
			Person.personList.remove(person);
		}
		return employee;

	}
	//Creates Manager object and rearranges the person list
	public Manager createManager(String [] words) throws Exception  {
		Person person = findPerson(words);
		Manager manager = new Manager((Employee)person,Double.parseDouble(words[2]));
		if (!Person.personList.contains(manager))
			Person.personList.add(manager);
		Person.personList.remove(person);
		return manager;

	}
	//Creates RegularEmployee object and rearranges the person list
	public RegularEmployee createRegEmp(String [] words) throws Exception {
		Person person = findPerson(words);
		RegularEmployee regularEmployee= new RegularEmployee((Employee)person, Double.parseDouble(words[2]));
		if(!Person.personList.contains(regularEmployee))
			Person.personList.add(regularEmployee);
		Person.personList.remove(person);
		return regularEmployee;

	}
	//Creates Developer object and rearranges the person list
	public Developer createDev(String [] words) throws Exception {
		Person person = findPerson(words);
		ArrayList<Project> currentList = new ArrayList<Project>();
		for(int k = 0; k< Project.allProjectList.size(); k++) {
			for (int j = 2 ; j<words.length; j++ ) {

				if(words[j].equals(Project.allProjectList.get(k).getProjectName())) {
					currentList.add(Project.allProjectList.get(k));
				}
			}
		}
		Developer developer = new Developer((RegularEmployee)person,currentList );
		if(!Person.personList.contains(developer))
			Person.personList.add(developer);
		Person.personList.remove(person);
		return developer;

	}
	//Creates SalesEmployee object and rearranges the person list
	public SalesEmployee createSalEmp(String [] words) throws Exception {
		Person person = findPerson(words);
		ArrayList<Product> currentList = new ArrayList<Product>();
		for(int k = 0; k< Product.allProductList.size(); k++) {
			for (int j = 2 ; j< words.length; j++ ) {
				if(words[j].equals(Product.allProductList.get(k).getProductName())) {
					currentList.add(Product.allProductList.get(k));
				}
			}
		}
		SalesEmployee salEmp = new SalesEmployee((RegularEmployee)person, currentList);
		if(!Person.personList.contains(salEmp))
			Person.personList.add(salEmp);
		Person.personList.remove(person);
		return salEmp;

	}
	//Finds person with the given ID
	public Person findPerson(String[] words) throws Exception {
		for (Person x : Person.personList) {
			if (x.getId() == Integer.parseInt(words[1])) {
				return x;
			}
		}
		throw new Exception("Person with ID " + words[1] + " not found.");
	}
	//Finds department with the given name
	public Department findDepartment(String [] words) throws Exception {
		for(Department y : Department.depList) {
			if(words[4].equals(y.getDepartmentName())) {
				return y;
			}
		}
		throw new Exception("Department with name " + words[4] + " not found.");

	}
	//Finds the sales employee who makes the most sales
	public double mostSale() {
		double max=0;
		for (Person p: Person.personList) {
			if(p instanceof SalesEmployee) {
				SalesEmployee salEmp = ((SalesEmployee) p);
				if (salEmp.salesValue()> max)
					max= salEmp.salesValue();
			}
		}
		return max;
	}
}
