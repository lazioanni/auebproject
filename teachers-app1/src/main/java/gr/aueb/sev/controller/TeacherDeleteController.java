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
import gr.aueb.sev.dao.teacher.ITeacherDAO;
import gr.aueb.sev.dao.teacher.TeacherDAOImpl;
import gr.aueb.sev.dto.EmailDTO;
import gr.aueb.sev.model.Email;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.email.EmailServiceImpl;
import gr.aueb.sev.service.email.IEmailService;
import gr.aueb.sev.service.teacher.ITeacherService;
import gr.aueb.sev.service.teacher.TeacherServiceImpl;
/**
 * Servlet implementation class TeacherDeleteCotroller
 */
@WebServlet("/deleteTeacher")
public class TeacherDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
	
	IEmailDAO emailDAO = new EmailDAOImpl();
	IEmailService emailServ = new EmailServiceImpl(emailDAO);
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id").trim();
		
		int id  = Integer.parseInt(idParam);
		List<Teacher> teachers = new ArrayList<>();
		Gson gson = new Gson();
		String gsonResponse;
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		try {
			Teacher teacher = teacherServ.getTeacherById(id);
			
			Email emailGet = emailServ.getUserById(teacher.getEmailId());
			
			EmailDTO emailDTO = new EmailDTO();
			
			emailDTO.setId(emailGet.getId());
			
			emailServ.delete(emailDTO);
			
			teachers = teacherServ.getAllTeachers();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (teachers != null) {
			gsonResponse = gson.toJson(teachers);
			response.getWriter().write(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}
		
		
		
	}

}
