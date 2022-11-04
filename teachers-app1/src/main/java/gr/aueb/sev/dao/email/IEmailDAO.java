package gr.aueb.sev.dao.email;

import java.sql.SQLException;

import gr.aueb.sev.model.Email;


public interface IEmailDAO {
	void insert(Email email) throws SQLException;
    void delete(Email email) throws SQLException;
	Email getUserByEmail(String email) throws SQLException;
	Email getEmailById(int id) throws SQLException;
}
