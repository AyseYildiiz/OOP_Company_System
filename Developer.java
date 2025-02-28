//This class is a template for creating developers.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee {
	//Data fields
	private ArrayList< Project > projects;//Shows a set of projects that the developer works on
	public static int numberOfDevelopers;
	//Constructor
	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore,
			ArrayList<Project> p) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				pScore);
		this.projects = p;
		numberOfDevelopers+=1;
	}
	//Constructor
	public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception {
		super(re, re.getPerformanceScore());
		this.projects = p;
		numberOfDevelopers+=1;
	}
	//Methods for arranging projects list
	public boolean addProject(Project s) {
		return projects.add(s);

	}
	public boolean removeProject(Project s) {
		return projects.remove(s);

	}
	//Getter setter methods
	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}
	public static void setNumberOfDevelopers(int numberOfDevelopers) {
		Developer.numberOfDevelopers = numberOfDevelopers;
	}
	@Override
	public String toString() {
		return super.toString() + "\t\t\t\tDeveloper " + projects + "]";
	}

}
