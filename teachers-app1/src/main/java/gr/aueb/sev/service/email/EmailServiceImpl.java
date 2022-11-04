package gr.aueb.sev.service.email;

import java.sql.SQLException;

import gr.aueb.sev.dao.email.IEmailDAO;
import gr.aueb.sev.dto.EmailDTO;
import gr.aueb.sev.model.Email;

public class EmailServiceImpl implements IEmailService {
	private final IEmailDAO emailDAO;

	public EmailServiceImpl(IEmailDAO emailDAO) {
		this.emailDAO = emailDAO;
	}

	@Override
	public void insert(EmailDTO emailDTO) throws SQLException {
		try {
			emailDAO.insert(this.extract(emailDTO));
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void delete(EmailDTO emailDTO) throws SQLException {
		Email email = this.extract(emailDTO);

		try {
			emailDAO.delete(email);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public Email getUserByEmail(String email) throws SQLException {
		try {
			return emailDAO.getUserByEmail(email);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	private Email extract(EmailDTO emailDTO) {
		Email email = new Email();
		email.setEmail(emailDTO.getEmail());
		email.setId(emailDTO.getId());
		return email;
	}

	@Override
	public Email getUserById(int id) throws SQLException {
		return emailDAO.getEmailById(id);
	}	
}
