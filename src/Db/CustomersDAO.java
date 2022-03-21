package Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Customers;


public class CustomersDAO {
private Connection conexao;
	
	public CustomersDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	
	public void insert(Customers ct) {
		String sql = "insert into customers (company, last_name, first_name, mobile_phone,city,state_province,zip_postal_code, country_region) values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			
			//stmt.setInt(1, os.getId());
			stmt.setString(1, ct.getCompany());
			stmt.setString(2, ct.getLast_name());
			stmt.setString(3, ct.getFirst_name());
			stmt.setString(4, ct.getMobile_phone());
			stmt.setString(5, ct.getCity());
			stmt.setString(6, ct.getState_province());
			stmt.setString(7, ct.getZip_postal_code());
			stmt.setString(8, ct.getCountry_region());
			
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e) {
			e.getMessage();
		}
	}
	
	
	public void select() {
		String sql = "SELECT first_name , last_name FROM customers ;";
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				
				Customers os = new Customers();
				os.setFirst_name(first_name);
				os.setLast_name(last_name);
				
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			//imprimir a lista
			for (Customers status : lista) {
				System.out.println("Client: "+ status.getFirst_name() +" "+ status.getLast_name());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectById(int id) {
		String a = "SELECT * FROM northwind.customers WHERE id LIKE ";
		
		String sql = a + id;
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String company = rs.getString("company");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String mobile_phone = rs.getString("mobile_phone");
				String city = rs.getString("city");
				String state_province = rs.getString("state_province");
				String zip_postal_code = rs.getString("zip_postal_code");
				String country_region = rs.getString("country_region");	
								
				Customers os = new Customers();
				os.setCompany(company);
				os.setFirst_name(first_name);
				os.setLast_name(last_name);
				os.setMobile_phone(mobile_phone);
				os.setCity(city);
				os.setState_province(state_province);
				os.setZip_postal_code(zip_postal_code);
				os.setCountry_region(country_region);
							
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			//imprimir a lista
			for (Customers status : lista) {
				System.out.println(status.toString());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}				
		
	}
	
	public void selectByFirstName(String name) {
		String b = " '%";
		String c = "%' ;";
		String a = "SELECT * FROM customers WHERE first_name OR last_name LIKE";
		String sql = a+b+name+c;
		
		List<Customers> lista = new ArrayList<Customers>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				
				Customers os = new Customers();
				os.setFirst_name(first_name);
				os.setLast_name(last_name);
				
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			//imprimir a lista
			for (Customers status : lista) {
				System.out.println("Client: "+ status.getFirst_name() +" "+ status.getLast_name());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}
