package com.jdbc.learning.dao;

import java.sql.SQLException;

import com.jdbc.learning.entity.Employe;

public interface EmployeDao {
	
	
	
	public void saveEmploye(Employe e) throws SQLException;
	
	public void updateEmploye(Employe e) throws SQLException;;
	
	public void deleteEmploye(int id) throws SQLException;;
	
	public void getEmploye(int id) throws SQLException;;
	
	public void printALLEmploye() throws SQLException;;

}
