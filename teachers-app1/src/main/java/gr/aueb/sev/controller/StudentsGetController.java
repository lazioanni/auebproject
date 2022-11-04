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

import gr.aueb.sev.dao.student.IStudentDAO;
import gr.aueb.sev.dao.student.StudentDAOImpl;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.student.IStudentService;
import gr.aueb.sev.service.student.StudentsServiceImpl;

@WebServlet("/getStudents")
public class StudentsGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		IStudentDAO studentDAO = new StudentDAOImpl();
		IStudentService studentServ = new StudentsServiceImpl(studentDAO);
		List<Student> students = new ArrayList<>();
		
		Gson gson = new Gson();
		String gsonResponse;
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		try {
			students = studentServ.getAllStudents();
		} catch (SQLException e) {
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

