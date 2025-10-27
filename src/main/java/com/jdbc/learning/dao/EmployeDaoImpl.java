package com.jdbc.learning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.learning.entity.Employe;
import com.mysql.cj.protocol.Resultset;

public class EmployeDaoImpl implements EmployeDao {
	private static final String INSERT_QUERY_BY_PS = "INSERT INTO EMPLOYEE VALUES (?,?,?,?)";
	static String INSERT_QUERY = "insert into student values(%d,'%s','%s',%d)";
	
	private static Connection connection;

	static {
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learningDB","root","123@Vpark");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveEmploye(Employe e) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into student values("+e.getId()+",'"+e.getName()+"','"+e.getGender()+"',"+e.getSalary()+")");
		statement.close();
		System.out.println("EMPLOYEE INFO SAVE FOR ID" + e.getId());
	}

	@Override
	public void updateEmploye(Employe e) throws SQLException {
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("update student set name ='"+ e.getName() +"',Gender ='"+ e.getGender() + "', Salary="+e.getSalary()+" where id ="+e.getId());
		statement.close();
		System.out.println("UPDATE DONE FOR ID " + e.getId());
	}

	@Override
	public void deleteEmploye(int id)throws SQLException {
        Statement statement = connection.createStatement();
		statement.executeUpdate("delete from student where id=" +id);
		statement.close();
		System.out.println("delete DONE FOR ID " + id);
	}

	@Override
	public void getEmploye(int id) {
		
		return;
		
	}

	@Override
	public void printALLEmploye()throws SQLException {
		 Statement statement = connection.createStatement();
			ResultSet rs =statement.executeQuery("select * from student ");
			while(rs.next()) {
				System.out.println("Employeeid "+ rs.getInt(1) +"\t Name =" +rs.getString(2)+"\t Gender = " +rs.getString(3)+"\t Salary =" + rs.getInt(4));
			}
			statement.close();
			System.out.println("select * from student");
	}
	@Override
	public void saveEmpByPs(Employe e){
	
		try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_BY_PS)) {

			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getGender());
			ps.setInt(4, e.getSalary());
			ps.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("EmployeeDaoImpl.saveEmpByPs()");
	}


	@Override
	public void insertBatch() throws SQLException {
		connection.setAutoCommit(false);
		PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_BY_PS);

		
		for(int i=1;i<=100;i++) {
			 
				ps.setInt(1, 11+i);
				ps.setString(2, "ARJUN" +i);
				ps.setString(3, "M");
				ps.setInt(4, 60_000);
				ps.addBatch();
				
				if(i%100 == 0) {
					ps.executeBatch();
					connection.commit();
				}
		}
		
	}
}
	