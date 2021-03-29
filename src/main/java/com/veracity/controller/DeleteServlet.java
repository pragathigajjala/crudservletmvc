package com.veracity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veracity.dao.EmpDao;

public class DeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		boolean isDeleted = new EmpDao().delete(id);
		if(isDeleted)
			pw.write("<h1>Records Deleted successully</h1>");
		else
			pw.write("<h2 style='color:red'>Unable to delete</h2>");
	
	}

}
