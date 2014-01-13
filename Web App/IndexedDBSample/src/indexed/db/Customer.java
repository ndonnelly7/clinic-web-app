package indexed.db;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long key;
	
	private String name,address,number,email;
	private String item,salesman,store_location;
	private Date dob;
	
	public Customer(String name, String address, String number, String email,
			String item, String salesman, String store_location, Date dob) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.email = email;
		this.item = item;
		this.salesman = salesman;
		this.store_location = store_location;
		this.dob = dob;
		
		Random random = new Random();
		key = (long) (Math.abs(random.nextLong()));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getStore_location() {
		return store_location;
	}
	public void setStore_location(String store_location) {
		this.store_location = store_location;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getKey() {
		return key;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", number="
				+ number + ", email=" + email + ", item=" + item
				+ ", salesman=" + salesman + ", store_location="
				+ store_location + ", dob=" + dob + ", key=" + key + "]";
	}
	
	
}
