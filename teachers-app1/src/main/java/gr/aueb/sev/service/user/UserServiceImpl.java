package gr.aueb.sev.service.user;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.user.IUserDAO;
import gr.aueb.sev.dto.UserDTO;
import gr.aueb.sev.model.User;

public class UserServiceImpl implements IUserService {
	private final IUserDAO userDAO;

	public UserServiceImpl(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void insert(UserDTO userDTO) throws SQLException {
		try {
			userDAO.insert(this.extract(userDTO));
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void delete(UserDTO userDTO) throws SQLException {
		User user = this.extract(userDTO);

		try {
			userDAO.delete(user);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public User getUserByEmail(int emailId) throws SQLException {
		try {
			return userDAO.getUserByEmailId(emailId);
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public List<User> getAllTeachers() throws SQLException {
		return userDAO.getAllTeachers();
	}

	@Override
	public List<User> getAllStudents() throws SQLException {
		return userDAO.getAllStudents();
	}
	
	private User extract(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setEmailId(userDTO.getEmailId());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		return user;
	}

}
