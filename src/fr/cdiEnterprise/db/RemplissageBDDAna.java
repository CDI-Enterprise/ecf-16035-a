package fr.cdiEnterprise.db;

import java.sql.SQLException;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;


public class RemplissageBDDAna {

	public static void main(String[] args) throws SQLException {
// Programme � n'utilser qu'une seule fois pour remplir la base de donn�es � partir du package dao

		DataBaseAn dataB = new DataBaseAn();


		/*Remplissage de la base de donn�es � partir de la dao*/

		/* Remplissage des d�partments */
		
		for (Department department : Datas.getDepartmentsList()){
//			
			DataBaseAccessAna.insertDepartmentData(department);
		}
		

		
		/*Region*/
		for (Region region : Datas.getRegionsList()){
			
			DataBaseAccessAna.insertRegionData(region);
		}
		
//		System.out.println(DataBaseAccess.getThemesData());
	
		/*Language*/	
		for (Language language : Datas.getLanguagesCompanyList()){
			
			DataBaseAccessAna.insertLanguageData(language);
		}
//		
//		System.out.println(DataBaseAccess.getEditeursData());
	
	}

}
