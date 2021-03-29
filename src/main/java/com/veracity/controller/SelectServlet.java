package com.veracity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veracity.dao.EmpDao;
import com.veracity.entity.Employee;

public class SelectServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	res.setContentType("text/html");
	PrintWriter pw = res.getWriter();
	Employee e = new EmpDao().select(id);
	if(e == null) {
		pw.write("<h2>Record not found</h2>");
	}else {
		pw.write("<h3>Employee Details</h3>");
		pw.write(" id :: "+e.getId());
		pw.write(" Name :: "+e.getName());
		pw.write(" Salary :: "+e.getSal());
	}
}
}


