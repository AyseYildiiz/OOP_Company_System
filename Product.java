//This class is a template for creating products.
//Ayşe Yıldız ID: 150122015
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Product {
	//Data fields
	private String productName;
	private java.util.Calendar saleDate;
	private double price;
	public static ArrayList<Product> allProductList = new ArrayList<Product>(); //Shows all products
	//Constructor
	public Product(String sName, Calendar sDate, double price) throws Exception {
		setProductName(sName);
		setSaleDate(sDate);
		setPrice(price);

	}
	//Getter setter methods
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) throws Exception {
		if (productName == null || productName.trim().isEmpty()) {
			throw new Exception("Product name cannot be blank");
		}
		if (productName.length() < 3) {
			throw new Exception("Product name must be at least 3 characters long");
		}
		this.productName = productName;
	}
	public java.util.Calendar getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(java.util.Calendar saleDate) throws Exception {
		if (saleDate == null) {
			throw new Exception("Sale date cannot be null");
		}
		this.saleDate = saleDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) throws Exception {
		if (price <= 0) {
			throw new Exception("Price must be positive");
		}
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", transactionDate=" + ((GregorianCalendar)saleDate).get(Calendar.DATE) +"/"+((GregorianCalendar)saleDate).get(Calendar.MONTH)+"/"+((GregorianCalendar)saleDate).get(Calendar.YEAR) + ", price=" + price + "]";
	}

}
