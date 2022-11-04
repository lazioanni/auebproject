package gr.aueb.sev.service.user;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.UserDTO;
import gr.aueb.sev.model.User;

public interface IUserService {
	void insert(UserDTO userDTO) throws SQLException;
    void delete(UserDTO userDTO) throws SQLException;
	User getUserByEmail(int emailId) throws SQLException;
	List<User> getAllTeachers() throws SQLException;
	List<User> getAllStudents() throws SQLException;	
}
