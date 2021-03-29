package com.veracity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veracity.dao.EmpDao;



public class UpdateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int sal = Integer.parseInt(req.getParameter("sal"));
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		boolean isUpdated = new EmpDao().update(id,sal);
		if(isUpdated)
			pw.write("<h1>Records Updated successully</h1>");
		else
			pw.write("<h2 style='color:red'>Unable to update</h2>");
	
	}
	
}
