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

import gr.aueb.sev.dao.course.CourseDAOImpl;
import gr.aueb.sev.dao.course.ICourseDAO;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.course.CourseServiceImpl;
import gr.aueb.sev.service.course.ICourseService;
/**
 * Servlet implementation class CourseDeleteController
 */
@WebServlet("/deleteCourse")
public class CourseDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id").trim();
		
		int id  = Integer.parseInt(idParam);
		List<Course> courses = new ArrayList<>();
		Gson gson = new Gson();
		String gsonResponse;
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		try{
			CourseDTO dto = new CourseDTO();
			dto.setId(id);
			courseServ.delete(dto);
			courses = courseServ.getAllCourses();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (courses != null) {
			gsonResponse = gson.toJson(courses);
			response.getWriter().write(gsonResponse);
			//System.out.println(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}	
	}	
		
}
