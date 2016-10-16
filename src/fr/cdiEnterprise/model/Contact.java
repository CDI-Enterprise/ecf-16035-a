package fr.cdiEnterprise.model;

/**
* Cette classe représente un contact qui sera renseigné par un utilisateur et affiché dans la fiche entreprise.
* 
* @author Anaïs
* @version 30-09-2016
*
*/

public class Contact {

	private String name;
	private String phoneNumber;
	private String email;

	
	public Contact(){
		
	}
	
	public Contact (String name, String phoneNumber, String email){
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name=name;
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
		return "Contact: " + name + phoneNumber + email;
	}
		
}
