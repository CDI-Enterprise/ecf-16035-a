package fr.cdiEnterprise.dao.test;


import java.sql.SQLException;

import fr.cdiEnterprise.dao.DataBaseCompany;
import fr.cdiEnterprise.dao.OldDatas;
import fr.cdiEnterprise.model.Department;
import fr.cdiEnterprise.service.Departments;
import fr.cdiEnterprise.service.Languages;
import fr.cdiEnterprise.service.Regions;





public class TestDBAna {

	public static void main(String[] args) throws SQLException {

//		OldDatas.init();
		
//Test de lecture des listes de la base de donn�es
//		Departments dpts= DataBaseCompany.getDepartmentListData();
//		Regions regs 	= DataBaseCompany.getRegionsListData();
//		Languages lgs =  DataBaseCompany.getLanguagesListData();
//		
//		System.out.println(dpts);
//		System.out.println(regs);
//		System.out.println(lgs);

//		Department dept;
	
//		dept = DataBaseCompany.getDepartmentName(13);
//		dept = DataBaseCompany.getDepartmentId("Ain");
//		System.out.println(dept);
		
		System.out.println(DataBaseCompany.getCompaniesData());
}
}