package fr.cdiEnterprise.model;

/**
 * Cette classe représente un langage informatique
 * 
 * @author Anaïs
 * @version 07-10-2016
 *
 */

public class Language {

	private String languageName;
	public static final String[] LANGUAGES = { "JAVA", "PhP", "CSS", "C#", "C++" };
	
	
	public Language(String nameL) {

		this.languageName = nameL;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return  languageName ;
	}
}
