package gr.aueb.sev.controller;

import java.io.IOException;
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


@WebServlet("/updateCourse")
public class CourseUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		String idParam = request.getParameter("id").trim();
		int id  = Integer.parseInt(idParam);
		
		List<Course> courses = new ArrayList<>();
		
		String title  = request.getParameter("title").trim();
		String description = request.getParameter("description").trim();
		int teacherId = Integer.parseInt(request.getParameter("teacherId").trim());
		
		//System.out.println(id+title+description+teacherId);
		
		CourseDTO dto = new CourseDTO(); 
		dto.setTitle(title);
		dto.setDescription(description);
		dto.setTeacherId(teacherId);
		
		CourseDTO dto1 = new CourseDTO();
		dto1.setId(id);
		
		Gson gson = new Gson();
		String gsonResponse;
		try {
			courseServ.update(dto1, dto);
			courses = courseServ.getAllCourses();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (courses != null) {
			gsonResponse = gson.toJson(courses);
			response.getWriter().write(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}
	}

}
