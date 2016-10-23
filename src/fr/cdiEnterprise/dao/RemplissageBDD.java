package fr.cdiEnterprise.dao;

import java.sql.SQLException;

import fr.cdiEnterprise.model.Department;

import fr.cdiEnterprise.model.Region;


public class RemplissageBDD {

	public static void main(String[] args) throws SQLException {
		// Programme à n'utilser qu'une seule fois pour remplir la base de données à partir du package dao

//				DataBase dataB = new DataBase();


				/*Remplissage de la base de données à partir de la dao*/

				/* Remplissage des départments */
				
				for (Department department : OldDatas.getDepartmentsList()){
//					
					DataBaseAccess.insertDepartmentData(department);
				}
				

				
				/*Region*/
				for (Region region : OldDatas.getRegionsList()){
					
					DataBaseAccess.insertRegionData(region);
				}
				

			
//				/*Language*/	
//				for (Language language : Datas.getLanguagesCompanyList()){
//					
//					DataBaseAccess.insertLanguageData(language);
//				}
//				

			
			}

		}
