//This class is a template for creating person and the superclass of Customer and Employee classes.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
	//Data fields
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private  boolean hasDriverLicence;
	public static ArrayList<Person> personList = new ArrayList<Person>();

	//Constructor
	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence) throws Exception {
		if (id <= 0 || firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty() ||
				gender == null || gender.trim().isEmpty() || maritalStatus == null || maritalStatus.trim().isEmpty() ||
				hasDriverLicence == null || hasDriverLicence.trim().isEmpty())
			throw new Exception(" Values should not be blank");
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.setGender(gender);
		this.birthDate = birthDate;
		this.setMaritalStatus(maritalStatus);
		this.setHasDriverLicence(hasDriverLicence);
	}

	//Getter setter methods 
	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		if (id <= 0)
			throw new Exception("ID must be positive");
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		if (firstName.length() < 3)
			throw new Exception("First name must be at least 3 characters long");
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws Exception {
		if (lastName.length() < 3)
			throw new Exception("Last name must be at least 3 characters long");

		this.lastName = lastName;
	}

	public String getGender() {
		if (this.gender ==1)
			return "Woman";
		else 
			return "Man";
	}

	public void setGender(String gender) throws Exception {
		if (gender == null )
			throw new Exception("Gender cannot be blank");
		if (gender.equals("Woman"))
			this.gender = 1;
		else if (gender.equals("Man"))
			this.gender = 2;
		else
			throw new Exception("Invalid gender");


	}

	public java.util.Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {
		if (this.maritalStatus == 1)
			return "Single";
		else 
			return "Married";

	}

	public void setMaritalStatus(String maritalStatus) throws Exception {
		if (maritalStatus == null )
			throw new Exception("Marital status cannot be blank");
		if (maritalStatus.equals("Single"))
			this.maritalStatus = 1;
		else if (maritalStatus.equals("Married"))
			this.maritalStatus = 2;
		else 
			throw new Exception("Invalid marital status");

	}

	public String getHasDriverLicence() {
		if (this.hasDriverLicence == true)
			return "Yes";
		else
			return "No";

	}

	public void setHasDriverLicence(String hasDriverLicence) throws Exception {
		if (hasDriverLicence == null)
			throw new Exception("Driver license status cannot be blank");
		if (hasDriverLicence.equals("Yes"))
			this.hasDriverLicence = true;
		else if (hasDriverLicence.equals("No"))
			this.hasDriverLicence = false;
		else
			throw new Exception("Invalid driver license status");
	}
	@Override
	public String toString() {
		return "Person Info [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender() + ", birthDate=" + ((GregorianCalendar)birthDate).get(Calendar.DATE) +"/"+((GregorianCalendar)birthDate).get(Calendar.MONTH)+"/"+((GregorianCalendar)birthDate).get(Calendar.YEAR) + ", maritalStatus=" + getMaritalStatus() + ", hasDriverLicence="
				+ getHasDriverLicence()+ "]";
	}

}
