package gr.aueb.sev.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.course.CourseDAOImpl;
import gr.aueb.sev.dao.course.ICourseDAO;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.service.course.CourseServiceImpl;
import gr.aueb.sev.service.course.ICourseService;


@WebServlet("/courseInsertForm")
public class CourseInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String title  = request.getParameter("courseTitle").trim();
		String description = request.getParameter("courseDescription").trim();
		int teacherId = Integer.parseInt(request.getParameter("courseTeacherId").trim());
		
		CourseDTO dto = new CourseDTO(); 
		dto.setTitle(title);
		dto.setDescription(description);
		dto.setTeacherId(teacherId);
		
		
		
		try {
			courseServ.insert(dto);
			
			request.setAttribute("insertedCourse", dto);
			request.getRequestDispatcher("/jsps/courseinserted.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
