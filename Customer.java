//This class is a template for creating customer.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person {
	//Data fields
	private ArrayList<Product> products;//Shows the products the customer bought
	//Constructor
	public Customer(int id, String firstName, String lastName, String gender, 
			Calendar birthDate, String maritalStatus,String hasDriverLicence, 
			ArrayList<Product> products) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.products = products;
	}
	//Constructor
	public Customer(Person person, ArrayList<Product> products) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(),person.getGender(),
				person.getBirthDate(), person.getMaritalStatus() ,person.getHasDriverLicence());
		this.products = products;
	}
	//Getter setter methods
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) throws Exception {
		if (products == null)
			throw new Exception("Products cannot be null");
		this.products = products;
	}

	@Override
	public String toString() {
		return  "Customer "+ "[id: " + getId()+" [products=" + products + "]";
	}

}
