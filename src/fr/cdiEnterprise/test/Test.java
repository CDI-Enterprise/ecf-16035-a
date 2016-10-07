package fr.cdiEnterprise.test;

import fr.cdiEnterprise.model.Company;
import fr.cdiEnterprise.model.Contact;
import fr.cdiEnterprise.service.Companies;

public class Test {
	public static void main(String[] args) {
		


	Company afpa = new Company("AFPA", "53Bd Laveran","13013", "MARSEILLE", 13, "PACA", "Formation", "Afpa.fr", null, new Contact("M", "D", "04","oi"));
	
	System.out.println(afpa);
	
	Companies liste = new Companies();
	
	System.out.println(liste);

}
}
