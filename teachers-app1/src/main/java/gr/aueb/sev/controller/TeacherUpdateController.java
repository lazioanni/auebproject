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

import gr.aueb.sev.dao.teacher.ITeacherDAO;
import gr.aueb.sev.dao.teacher.TeacherDAOImpl;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.teacher.ITeacherService;
import gr.aueb.sev.service.teacher.TeacherServiceImpl;


@WebServlet("/updateTeacher")
public class TeacherUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		List<Teacher> teachers = new ArrayList<>();
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String name  = request.getParameter("name").trim();
		String lastname = request.getParameter("lastname").trim();
		String rank = request.getParameter("rank").trim();
		String email = request.getParameter("email").trim();
		String subject = request.getParameter("subject").trim();
		String password = request.getParameter("password").trim();
		
		System.out.println(id+name+lastname+rank+email+subject+password);
		
		TeacherDTO dto = new TeacherDTO(); 
		dto.setFirstname(name);
		dto.setLastname(lastname);
		dto.setRank(rank);
		dto.setSubject(subject);
		dto.setId(id);
		
		Teacher teacher = new Teacher();
		
		try {
			teacher = teacherServ.getTeacherById(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dto.setEmailId(teacher.getEmailId());
		
		TeacherDTO dto1 = new TeacherDTO();
		dto1.setId(id);
		
		Gson gson = new Gson();
		String gsonResponse;
		try {
			teacherServ.updateTeacher(dto1, dto);
			teachers = teacherServ.getAllTeachers();
		}catch(Exception e) {
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
