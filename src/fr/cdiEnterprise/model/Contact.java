package fr.cdiEnterprise.model;

/**
* Cette classe repr�sente un contact qui sera renseign� par un utilisateur et affich� dans la fiche entreprise.
* 
* @author Ana�s
* @version 30-09-2016
*
*/

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

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	
	@Override
	public String toString() {
		return "Contact: " + firstName + lastName + phoneNumber + email;
	}
		
}
