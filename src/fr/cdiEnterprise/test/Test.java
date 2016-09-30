package fr.cdiEnterprise.test;

import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Contact;
import fr.cdiEnterprise.persistence.Companies;

public class Test {
	public static void main(String[] args) {
		


	Company afpa = new Company("AFPA", "53Bd Laveran","13013", "MARSEILLE", 13, "PACA", "Formation", "Afpa.fr", new Contact("M", "D", "04","oi"));
	
	Companies liste = new Companies();
	

}
}
