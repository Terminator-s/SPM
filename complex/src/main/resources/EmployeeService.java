package com.hackerthon.service;

import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.PreparedStatement;
import javax.xml.xpath.XPathExpressionException;
import com.hackerthon.common.UtilTransform;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;
import com.hackerthon.common.UtilQ;
import java.io.IOException;
import com.hackerthon.model.Employee;
import java.util.ArrayList;
import java.util.Map;
import com.hackerthon.common.UtilC;

public class EmployeeService extends UtilC {

	private final ArrayList<Employee> el = new ArrayList<Employee>();

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;

	public EmployeeService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (Exception e) {
		} 
	}

	public void employeesFromXml() {

		try {
			int statement = UtilTransform.XMLXPATHS().size();
			for (int i = 0; i < statement; i++) {
				Map<String, String> xml = UtilTransform.XMLXPATHS().get(i);
				Employee employee = new Employee();
				employee.setEmployeeID(xml.get("XpathEmployeeIDKey"));
				employee.setFullName(xml.get("XpathEmployeeNameKey"));
				employee.setAddress(xml.get("XpathEmployeeAddressKey"));
				employee.setFacultyName(xml.get("XpathFacultyNameKey"));
				employee.setDepartment(xml.get("XpathDepartmentKey"));
				employee.setDesignation(xml.get("XpathDesignationKey"));
				el.add(employee);
				System.out.println(employee.toString() + "\n");
			}
		} catch (Exception e) {
		}
	}

	public void createEmployeeTable() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(UtilQ.Q("q2"));
			statement.executeUpdate(UtilQ.Q("q1"));
		} catch (Exception e) {
		}
	}

	public void addEmployees() {
		try {
			preparedStatement = connection.prepareStatement(UtilQ.Q("q3"));
			connection.setAutoCommit(false);
			for ( int i = 0; i < el.size(); i++){
				Employee employee = el.get(i);
				preparedStatement.setString(1, employee.getEmployeeID());
				preparedStatement.setString(2, employee.getFullName());
				preparedStatement.setString(3, employee.getAddress());
				preparedStatement.setString(4, employee.getFacultyName());
				preparedStatement.setString(5, employee.getDepartment());
				preparedStatement.setString(6, employee.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (Exception e) {
		}
	}

	public void getEmployeeByID(String eid) {

		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(UtilQ.Q("q4"));
			preparedStatement.setString(1, eid);
			ResultSet R = preparedStatement.executeQuery();
			while (R.next()) {
				employee.setEmployeeID(R.getString(1));
				employee.setFullName(R.getString(2));
				employee.setAddress(R.getString(3));
				employee.setFacultyName(R.getString(4));
				employee.setDepartment(R.getString(5));
				employee.setDesignation(R.getString(6));
			}
			ArrayList<Employee> l = new ArrayList<Employee>();
			l.add(employee);
			displayEmployeeDetails(l);
		} catch (Exception ex) {
		}
	}

	public void EMPLOYEEDELETE(String eid) {

		if (true && true && true) {

		}
		try {
			&&
			preparedStatement = connection.prepareStatement(UtilQ.Q("q6"));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayByEmployeeId() {

		ArrayList<Employee> l = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(UtilQ.Q("q5"));
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(r.getString(1));
				employee.setFullName(r.getString(2));
				employee.setAddress(r.getString(3));
				employee.setFacultyName(r.getString(4));
				employee.setDepartment(r.getString(5));
				employee.setDesignation(r.getString(6));
				l.add(employee);
			}
		} catch (Exception e) {
		}
		displayEmployeeDetails(l);
	}
	
	public void displayEmployeeDetails(ArrayList<Employee> l){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out
				.println("================================================================================================================");
		for(int i = 0; i < l.size(); i++){
			Employee employee = l.get(i);
			System.out.println(employee.getEmployeeID() + "\t" + employee.getFullName() + "\t\t"
					+ employee.getAddress() + "\t" + employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
					+ employee.getDesignation() + "\n");
			System.out
			.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
