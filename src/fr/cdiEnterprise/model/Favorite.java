/**
 * 
 */
package fr.cdiEnterprise.model;

/**
 * Exemple List of company
 * 
 *14 oct. 2016
 * @author Ismael
 *ecf-16035-a
 *22:06:18
 */

public class Favorite 
{
private static int id;
private int idEnterprise;
private String companyName;

public static final String[] FAVORITES ={"First DAO", "Second JAVA", "Third Windows", "Fourth UML", "Fifth SQL", "Sixth PENCIL", 
		"Seven POWERAMC","Eighth BALSAMIQUE", "Ninth WEB", "Tenth ZERO"};

/**
 * Default constructor
 */

public Favorite() 
{
	
}

/**
 * Constructor with parameters
 * 
 * @param companyName
 * @param city
 */

public Favorite(String companyName) 
{
	super();
	id++;
	this.companyName = companyName;
	this.idEnterprise = id;
}

/**
 * Getters
 */

/**
 * @return the companyName
 */
public String getCompanyName() {
	return companyName;
}

/**
 * @return the idEnterprise
 */
public int getIdEnterprise() {
	return idEnterprise;
}

/**
 * Setters
 */

/**
 * @param companyName
 * the companyName to set
 */
public void setCompanyName(String companyName) 
{
	this.companyName = companyName;
}

/**
 * @param idEnterprise
 *            the idEnterprise to set
 */
public void setIdEnterprise(int idEnterprise) 
{
	this.idEnterprise = idEnterprise;
}

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

@Override
public String toString() 
{
	return companyName;
}

@Override
public void finalize() {
	System.gc();
	System.out.println("This is end");
				}
}
