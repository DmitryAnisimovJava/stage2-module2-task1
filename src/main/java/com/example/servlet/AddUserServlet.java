package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.User;
import com.example.Warehouse;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.sendRedirect("/json/add.jsp");
    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firsrName = req.getParameter("firstName");
		String secondName = req.getParameter("lastName");
		System.out.println(firsrName + " " + secondName);
		User userObject = new User(firsrName, secondName);
		Warehouse.getInstance().addUser(userObject);
		req.setAttribute("user", userObject);
		req.getRequestDispatcher("/json/add.jsp").forward(req, resp);
	}
}
