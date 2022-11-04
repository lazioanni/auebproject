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
import gr.aueb.sev.dao.teacher.ITeacherDAO;
import gr.aueb.sev.dao.teacher.TeacherDAOImpl;
import gr.aueb.sev.dao.user.IUserDAO;
import gr.aueb.sev.dao.user.UserDAOImpl;
import gr.aueb.sev.dto.EmailDTO;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.dto.UserDTO;
import gr.aueb.sev.enums.ROLE;
import gr.aueb.sev.model.Email;
import gr.aueb.sev.service.email.EmailServiceImpl;
import gr.aueb.sev.service.email.IEmailService;
import gr.aueb.sev.service.teacher.ITeacherService;
import gr.aueb.sev.service.teacher.TeacherServiceImpl;
import gr.aueb.sev.service.user.IUserService;
import gr.aueb.sev.service.user.UserServiceImpl;

/**
 * Servlet implementation class TeacherInsertController
 */
@WebServlet("/teacherInsertForm")
public class TeacherSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
	
	IEmailDAO emailDAO = new EmailDAOImpl();
	IEmailService emailServ = new EmailServiceImpl(emailDAO);
	
	IUserDAO userDAO = new UserDAOImpl();
	IUserService userServ = new UserServiceImpl(userDAO);
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String firstname = request.getParameter("teachername").trim();
		String lastname = request.getParameter("teacherlastname").trim();
		String subject = request.getParameter("teachersubject").trim();
		String rank = request.getParameter("teacherRank").trim();
		String email = request.getParameter("teacheremail").trim();
		String password = request.getParameter("teacherpassword").trim();
		
		
		TeacherDTO teacherDTO = new TeacherDTO(); 
		teacherDTO.setFirstname(firstname);
		teacherDTO.setLastname(lastname);
		teacherDTO.setRank(rank);
		teacherDTO.setSubject(subject);
		
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setEmail(email);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setPassword(password);
		userDTO.setRole(ROLE.TEACHER.toString());
		
		try {
			emailServ.insert(emailDTO);
			Email emailGet = emailServ.getUserByEmail(email);
			//System.out.println(emailGet.toString());
			
			userDTO.setEmailId(emailGet.getId());
			userServ.insert(userDTO);
			//System.out.println(userDTO.toString());
			
			teacherDTO.setEmailId(emailGet.getId());
			teacherServ.insertTeacher(teacherDTO);
			//System.out.println("inserted");
			//System.out.println(teacherDTO.toString());
			
			request.setAttribute("insertedTeacher", teacherDTO);
			request.getRequestDispatcher("/jsps/teacherinserted.jsp").forward(request, response);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
