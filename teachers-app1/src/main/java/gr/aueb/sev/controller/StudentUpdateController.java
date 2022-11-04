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
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.student.IStudentService;
import gr.aueb.sev.service.student.StudentsServiceImpl;


@WebServlet("/updateStudent")
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentsServiceImpl(studentDAO);
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		List<Student> students = new ArrayList<>();
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String name  = request.getParameter("name").trim();
		String lastname = request.getParameter("lastname").trim();
		String rank = request.getParameter("rank").trim();
		String email = request.getParameter("email").trim();
		String university = request.getParameter("university").trim();
		String password = request.getParameter("password").trim();
		
		//System.out.println(id+name+lastname+rank+email+university+password);
		
		StudentDTO dto = new StudentDTO(); 
		dto.setFirstname(name);
		dto.setLastname(lastname);
		dto.setRank(rank);
		dto.setUniversity(university);
		dto.setId(id);
		
		Student student = new Student();
		
		try {
			student = studentServ.getStudentById(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dto.setEmailId(student.getEmailId());
		
		StudentDTO dto1 = new StudentDTO();
		dto1.setId(id);
		
		Gson gson = new Gson();
		String gsonResponse;
		try {
			studentServ.update(dto1, dto);
			students = studentServ.getAllStudents();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (students != null) {
			gsonResponse = gson.toJson(students);
			response.getWriter().write(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}
	}

   

}
