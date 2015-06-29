/**
 * 
 */
package com.isse.serviceImpl;

import java.util.List;

import com.isse.dao.TProfessionDAO;
import com.isse.model.TProfession;
import com.isse.service.ProfessionService;

/**
 * @author ming
 *
 */
public class ProfessionServiceImpl implements ProfessionService {
     
	private TProfessionDAO tProfessionDAO;
	/* (non-Javadoc)
	 * @see com.isse.service.ProfessionService#findTProfessionsByTeaCode(java.lang.String)
	 */
	@Override
	public List<TProfession> findTProfessionsByTeaCode(String teaCode) {
		// TODO Auto-generated method stub
		return this.tProfessionDAO.findProfessionsByTeaCode(teaCode);
	}
	public TProfessionDAO gettProfessionDAO() {
		return tProfessionDAO;
	}
	public void settProfessionDAO(TProfessionDAO tProfessionDAO) {
		this.tProfessionDAO = tProfessionDAO;
	}

}
