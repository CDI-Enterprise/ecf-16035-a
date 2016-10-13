package fr.cdiEnterprise.model;

/**
 * Cette classe représente un langage de programmation informatique.
 * 
 * @author Anaïs
 * @version 13-10-2016
 *
 */

public class Language {

	private static int languageId;								// Auto-generated language's id

	private int id;
	private String languageName;

	/**
	 * Default constructor
	 */
	public Language(String languageName) {
		languageId++;
		this.id = languageId;
		this.languageName = languageName;
		
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Language [id=" + id + ", languageName=" + languageName + "]";
	}
	
}
