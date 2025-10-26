package com.jdbc.learning;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.learning.dao.EmployeDao;
import com.jdbc.learning.dao.EmployeDaoImpl;
import com.jdbc.learning.entity.Employe;
public class Main {

	public static void main(String[] args) throws SQLException //throws SQLException
	{
		
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learningDB","root","123@Vpark");
//		Statement statement = connection.createStatement();
//		statement.executeUpdate("insert into student values(04,'AK','Male',45000),(05,'RAJA','Male',43434)");
//		
//			
//		Employe e1 = new Employe("RAj" ,"male",11,39308);
		EmployeDao edao = new EmployeDaoImpl();
//		edao.saveEmploye(e1);
//		
//		Employe e2 = new Employe("YASH" ,"male",6,39308);
//		edao.updateEmploye(e2);
		
//		edao.deleteEmploye(5);
		
		edao.printALLEmploye();
		//		 DriverManager.getConnection("jdbc:mysql://localhost:3306/learningDB","root","123@Vpark").createStatement().executeUpdate("insert into student values(06,'Ajay','Male',45000)");
		 
		
		
				System.out.println("hello");

	}

}
