package fr.cdiEnterprise.db;

import java.sql.SQLException;

import fr.cdiEnterprise.dao.Datas;
import fr.cdiEnterprise.model.Department;


public class RemplissageBDD {

	public static void main(String[] args) throws SQLException {
// Programme à n'utilser qu'une seule fois pour remplir la base de données à partir du package dao

		DataBase dataB = new DataBase();


		/*Remplissage de la base de données à partir de la dao*/
//		System.out.println(Datas.getListeAuteursBiblio());
//		
		for (Department department : Datas.getDepartmentsList()){
//			
			DataBaseAccess.insertDepartmentData(department);
		}
		
//		System.out.println(DataBaseAccess.getAuteursData());
		
		/*Theme*/
//		System.out.println(Datas.getListeThemesBiblio());
		
//		for (Theme theme : Datas.getListeThemesBiblio()){
//			
//			DataBaseAccess.insertThemeData(theme);
//		}
		
//		System.out.println(DataBaseAccess.getThemesData());
	
		/*Editeur*/
	
//		System.out.println(Datas.getListeEditeursBiblio());
//		
//		for (Editeur editeur : Datas.getListeEditeursBiblio()){
//			
//			DataBaseAccess.insertEditeurData(editeur);
//		}
//		
//		System.out.println(DataBaseAccess.getEditeursData());
	
	}

}
