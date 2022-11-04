package gr.aueb.sev.dao.user;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.User;


public interface IUserDAO {
	void insert(User user) throws SQLException;
    void delete(User user) throws SQLException;
	User getUserByEmailId(int emailId) throws SQLException;
	List<User> getAllTeachers() throws SQLException;
	List<User> getAllStudents() throws SQLException;	
}
