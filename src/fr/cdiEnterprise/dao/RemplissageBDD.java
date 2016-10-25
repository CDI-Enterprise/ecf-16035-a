package fr.cdiEnterprise.dao;

import java.sql.SQLException;

import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.model.Language;
import fr.cdiEnterprise.model.Region;


public class RemplissageBDD {

	public static void main(String[] args) throws SQLException {

		OldDatas.init();
		
		// Programme à n'utilser qu'une seule fois pour remplir la base de données à partir du package dao


				/*Remplissage de la base de données à partir de la dao*/

				/* Remplissage des départments */
//		System.out.println(OldDatas.getDepartmentsList());
//				
//				for (Department department : OldDatas.getDepartmentsList()){
////					System.out.println(department);
//					DataBaseCompany.insertDepartmentData(department);
//					
//				}
//				
//				System.out.println("Effectué");
				
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
