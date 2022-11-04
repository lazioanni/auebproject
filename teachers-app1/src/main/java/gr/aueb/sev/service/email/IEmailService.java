package gr.aueb.sev.service.email;

import java.sql.SQLException;

import gr.aueb.sev.dto.EmailDTO;
import gr.aueb.sev.model.Email;

public interface IEmailService {
	void insert(EmailDTO emailDTO) throws SQLException;
    void delete(EmailDTO emailDTO) throws SQLException;
	Email getUserByEmail(String email) throws SQLException;
	Email getUserById(int id) throws SQLException;
}
