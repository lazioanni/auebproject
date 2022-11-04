package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.email.EmailDAOImpl;
import gr.aueb.sev.dao.email.IEmailDAO;
import gr.aueb.sev.model.Email;
import gr.aueb.sev.service.email.EmailServiceImpl;
import gr.aueb.sev.service.email.IEmailService;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IEmailDAO emailDAO = new EmailDAOImpl();
	IEmailService emailServ = new EmailServiceImpl(emailDAO);
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String eMail = request.getParameter("loginEmail");
		
		Email email = new Email();
		
		try {
			email = emailServ.getUserByEmail(eMail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (email.getId() != 0) {
			response.sendRedirect(request.getContextPath() + "/jsps/dashboard.jsp");
		} else {
			request.setAttribute("error", "Login Error");
			request.getRequestDispatcher("/").forward(request, response);
		}
				
	}

}
