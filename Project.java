//This class is a template for creating projects.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Project {
	//Data fields
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;
	public static ArrayList<Project> allProjectList = new ArrayList<Project>();//Shows all projects
	//Constructor
	public Project(String pName, Calendar startDate, String state) throws Exception {
		setProjectName(pName);
		setStartDate(startDate);
		setState(state);
	}
	//Getter setter methods
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) throws Exception {
		if (projectName == null) {
			throw new Exception("Project name cannot be blank");
		}
		if (projectName.length() < 3) {
			throw new Exception("Project name must be at least 3 characters long");
		}
		this.projectName = projectName;
	}

	public java.util.Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Calendar startDate) throws Exception {
		if (startDate == null) {
			throw new Exception("Start date cannot be null");
		}
		this.startDate = startDate;
	}

	public String getState() {
		if(this.state==true)
			return "Open";
		else 
			return "Close";
	}

	public void setState(String state) {
		if (state.equals("Open"))
			this.state = true;
		if (state.equals("Close"))
			this.state = false;
	}
	public void close() {
		if (this.state==true)
			this.setState("Close");
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", startDate=" + ((GregorianCalendar)startDate).get(Calendar.DATE) +"/"+((GregorianCalendar)startDate).get(Calendar.MONTH)+"/"+((GregorianCalendar)startDate).get(Calendar.YEAR) + ", state=" + getState() + "]";
	}

}

