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
import gr.aueb.sev.dao.student.IStudentDAO;
import gr.aueb.sev.dao.student.StudentDAOImpl;
import gr.aueb.sev.dao.user.IUserDAO;
import gr.aueb.sev.dao.user.UserDAOImpl;
import gr.aueb.sev.dto.EmailDTO;
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.dto.UserDTO;
import gr.aueb.sev.enums.ROLE;
import gr.aueb.sev.model.Email;
import gr.aueb.sev.service.email.EmailServiceImpl;
import gr.aueb.sev.service.email.IEmailService;
import gr.aueb.sev.service.student.IStudentService;
import gr.aueb.sev.service.student.StudentsServiceImpl;
import gr.aueb.sev.service.user.IUserService;
import gr.aueb.sev.service.user.UserServiceImpl;

@WebServlet("/studentSignUp")
public class StudentSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentsServiceImpl(studentDAO);
	
	IEmailDAO emailDAO = new EmailDAOImpl();
	IEmailService emailServ = new EmailServiceImpl(emailDAO);
	
	IUserDAO userDAO = new UserDAOImpl();
	IUserService userServ = new UserServiceImpl(userDAO);
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		
		String firstname = request.getParameter("studentname").trim();
		String lastname = request.getParameter("studentlastname").trim();
		String university = request.getParameter("university").trim();
		String rank = request.getParameter("studentRank").trim();
		String email = request.getParameter("studentemail").trim();
		String password = request.getParameter("studentpassword").trim();
			
		StudentDTO studentDTO = new StudentDTO(); 
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
		studentDTO.setRank(rank);
		studentDTO.setUniversity(university);
		
		//System.out.println(firstname+lastname+university+rank+email+password);
		
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setEmail(email);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setPassword(password);
		userDTO.setRole(ROLE.STUDENT.toString());
		
		try {
			emailServ.insert(emailDTO);
			Email emailGet = emailServ.getUserByEmail(email);
			//System.out.println(emailGet.toString());
			
			userDTO.setEmailId(emailGet.getId());
			userServ.insert(userDTO);
			//System.out.println(userDTO.toString());
			
			studentDTO.setEmailId(emailGet.getId());
			studentServ.insert(studentDTO);
			System.out.println("inserted");
			//System.out.println(teacherDTO.toString());
			
			request.setAttribute("insertedStudent", studentDTO);
			request.getRequestDispatcher("/jsps/studentinserted.jsp").forward(request, response);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}