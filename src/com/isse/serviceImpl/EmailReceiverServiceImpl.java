/**
 * 
 */
package com.isse.serviceImpl;

import com.isse.dao.TEmailReceiverDAO;
import com.isse.model.TEmailReceiver;
import com.isse.service.EmailReceiverService;

/**
 * @author ming
 *
 */
public class EmailReceiverServiceImpl implements EmailReceiverService {
     TEmailReceiverDAO tEmailReceiverDAO;
	/* (non-Javadoc)
	 * @see com.isse.service.EmailReceiverService#saveEmailReceiver(com.isse.model.TEmailReceiver)
	 */
	@Override
	public void saveEmailReceiver(TEmailReceiver tEmailReceiver) {
		// TODO Auto-generated method stub
		this.tEmailReceiverDAO.save(tEmailReceiver);

	}
	public TEmailReceiverDAO gettEmailReceiverDAO() {
		return tEmailReceiverDAO;
	}
	public void settEmailReceiverDAO(TEmailReceiverDAO tEmailReceiverDAO) {
		this.tEmailReceiverDAO = tEmailReceiverDAO;
	}

}
