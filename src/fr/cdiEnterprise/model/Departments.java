package fr.cdiEnterprise.model;

import java.util.ArrayList;

public class Departments extends ArrayList<Department> {

	private static final long serialVersionUID = 1L;

	public Department getDepartment(String name) {

		Department departmentFound = null;

		for (Department department : this) {
			if (department.getDepartmentName().equals(name)) {
				departmentFound = department;
			}
		}
		return departmentFound;
	}

}