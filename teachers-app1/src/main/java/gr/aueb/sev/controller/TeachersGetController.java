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
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.teacher.ITeacherService;
import gr.aueb.sev.service.teacher.TeacherServiceImpl;



@WebServlet("/getTeachers")
public class TeachersGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		List<Teacher> teachers = new ArrayList<>();
		
		Gson gson = new Gson();
		String gsonResponse;
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		try {
			teachers = teacherServ.getAllTeachers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (teachers != null) {
			gsonResponse = gson.toJson(teachers);
			response.getWriter().write(gsonResponse);
			//System.out.println(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}
	}
}
