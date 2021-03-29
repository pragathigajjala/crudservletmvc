package com.veracity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.veracity.entity.Employee;
import com.veracity.utility.ConnectionFactory;

public class EmpDao {
	
	public boolean register(Employee e) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getSal());

			int result = ps.executeUpdate();
			if (result == 1)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from employee where id=?");

			ps.setInt(1, id);

			int result = ps.executeUpdate();
			if (result == 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(int id, int sal) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("update employee set salary=? where id=?");

			ps.setInt(1, sal);
			ps.setInt(2, id);

			int result = ps.executeUpdate();
			if (result == 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Employee select(int id) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int i = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("salary");
				Employee e = new Employee(i, name, sal);
				return e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
