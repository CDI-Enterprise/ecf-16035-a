package fr.cdiEnterprise.dao;

import java.sql.SQLException;

import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;


public class RemplissageBDD {

	public static void main(String[] args) throws SQLException {

		OldDatas.init();
		
		// Programme � n'utilser qu'une seule fois pour remplir la base de donn�es � partir du package dao


				/*Remplissage de la base de donn�es � partir de la dao*/

				/* Remplissage des d�partments */
//		System.out.println(OldDatas.getDepartmentsList());
//				
//				for (Department department : OldDatas.getDepartmentsList()){
////					System.out.println(department);
//					DataBaseCompany.insertDepartmentData(department);
//					
//				}
//				
//				System.out.println("Effectu�");
				
				/*Region*/
//				for (Region region : OldDatas.getRegionsList()){
//					DataBaseCompany.insertRegionData(region);
//				}
//				System.out.println("ok");

			
//				/*Language*/	
				for (Language language : OldDatas.getLanguagesCompanyList()){
					
					DataBaseCompany.insertLanguageData(language.getLanguageName());
				}
//				

			
			}

		}
