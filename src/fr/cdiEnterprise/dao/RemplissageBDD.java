package fr.cdiEnterprise.dao;

import java.sql.SQLException;

import fr.cdiEnterprise.model.Department;

import fr.cdiEnterprise.model.Region;


public class RemplissageBDD {

	public static void main(String[] args) throws SQLException {
		// Programme � n'utilser qu'une seule fois pour remplir la base de donn�es � partir du package dao

//				DataBase dataB = new DataBase();


				/*Remplissage de la base de donn�es � partir de la dao*/

				/* Remplissage des d�partments */
				
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
