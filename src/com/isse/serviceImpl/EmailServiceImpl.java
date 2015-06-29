/**
 * 
 */
package com.isse.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isse.dao.TEmailDAO;
import com.isse.dao.TEmailReceiverDAO;
import com.isse.model.TEmail;
import com.isse.model.TEmailReceiver;
import com.isse.service.EmailService;

/**
 * @author ming
 *
 */
public class EmailServiceImpl implements EmailService {
	TEmailDAO tEmailDAO;
	TEmailReceiverDAO tEmailReceiverDAO;
	/* (non-Javadoc)
	 * @see com.isse.service.EmailService#saveEmail(com.isse.model.TEmail)
	 */
	@Override
	public void saveEmail(TEmail tEmail) {
		// TODO Auto-generated method stub
		this.tEmailDAO.save(tEmail);

	}

	
	public TEmailDAO gettEmailDAO() {
		return tEmailDAO;
	}
	public void settEmailDAO(TEmailDAO tEmailDAO) {
		this.tEmailDAO = tEmailDAO;
	}

	
	

}
