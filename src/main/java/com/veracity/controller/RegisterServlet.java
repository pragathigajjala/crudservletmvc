package com.veracity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veracity.dao.EmpDao;
import com.veracity.entity.Employee;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//data gather logic
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int sal = Integer.parseInt(req.getParameter("sal"));
		
		Employee e = new Employee(id, name, sal);
		
		//pass this data to the database
		boolean isAdded = new EmpDao().register(e);
	
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		if(isAdded) {
			pw.write("<h2>Record Added Successfully</h2>");
		}else {
			pw.write("<h2>Unable to Add</h2>");
		}
		
		
	}

}
