package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gr.aueb.sev.dao.email.EmailDAOImpl;
import gr.aueb.sev.dao.email.IEmailDAO;
import gr.aueb.sev.dao.student.IStudentDAO;
import gr.aueb.sev.dao.student.StudentDAOImpl;
import gr.aueb.sev.dto.EmailDTO;
import gr.aueb.sev.model.Email;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.email.EmailServiceImpl;
import gr.aueb.sev.service.email.IEmailService;
import gr.aueb.sev.service.student.IStudentService;
import gr.aueb.sev.service.student.StudentsServiceImpl;


@WebServlet("/deleteStudent")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentsServiceImpl(studentDAO);
	
	IEmailDAO emailDAO = new EmailDAOImpl();
	IEmailService emailServ = new EmailServiceImpl(emailDAO);
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id").trim();
		
		int id  = Integer.parseInt(idParam);
		List<Student> students = new ArrayList<>();
		Gson gson = new Gson();
		String gsonResponse;
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		try {
			Student student = studentServ.getStudentById(id);
			
			Email emailGet = emailServ.getUserById(student.getEmailId());
			
			EmailDTO emailDTO = new EmailDTO();
			emailDTO.setId(emailGet.getId());
			emailServ.delete(emailDTO);
			students = studentServ.getAllStudents();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (students != null) {
			gsonResponse = gson.toJson(students);
			response.getWriter().write(gsonResponse);
			//System.out.println(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}
		
		
		
	}

}