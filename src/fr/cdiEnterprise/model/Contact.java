package fr.cdiEnterprise.model;

public class Contact {

	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String email;

	
	public Contact(){
		
	}
	
	public Contact (String lastName,String firstName, String phoneNumber, String email){
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}

	private String getLastName() {
		return lastName;
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	private String getFirstName(){
		return firstName;
	}
	
	private void setFirstName(String firstName){
		this.firstName=firstName;
	}
	
	private String getPhoneNumber() {
		return phoneNumber;
	}
	
	private void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}

	private String getEmail(){
		return email;
	}
	
	private void setEmail(String email){
		this.email=email;
	}
	
	
	@Override
	public String toString() {
		return "Contact: " + firstName + lastName + phoneNumber + email;
	}
		
}
