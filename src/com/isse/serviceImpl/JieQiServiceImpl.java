/**
 * 
 */
package com.isse.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isse.dao.TJieqiDAO;
import com.isse.model.TJieqi;
import com.isse.service.JieQiService;
import com.util.PageBean;

/**
 * @author ming
 *
 */
public class JieQiServiceImpl implements JieQiService {
	private TJieqiDAO tJieqiDAO;
	/* (non-Javadoc)
	 * @see com.isse.service.JieQiService#findTJieqiByQici(java.lang.String)
	 */
	@Override
	public TJieqi findTJieqiByQici(String qici) {
		// TODO Auto-generated method stub
		List<TJieqi> jieqiList = this.tJieqiDAO.findByQici(qici);
		TJieqi tJieqi = null;
		if(jieqiList.size()>0){
			tJieqi = jieqiList.get(0);
		}
		return tJieqi;
	}
	
	//获取未分派的专家库的年份
	public List<BigDecimal> findUnassignYears(){
		return this.tJieqiDAO.findUnassignYears();
	}
	
	public TJieqiDAO gettJieqiDAO() {
		return tJieqiDAO;
	}
	public void settJieqiDAO(TJieqiDAO tJieqiDAO) {
		this.tJieqiDAO = tJieqiDAO;
	}
	/* (non-Javadoc)
	 * @see com.isse.service.JieQiService#findCurrentJieQi()
	 */
	/**
	 * lsp 根据当前时间获取届期（当前申报的）
	 */
	@Override
	public TJieqi findCurrentJieQi() {
		return this.tJieqiDAO.getJieqiNow();
	}
	// 获取当前结题届期
	public TJieqi findJieQiNow()
	{
		return this.tJieqiDAO.getCurrentJieqi();
	}

	/* (non-Javadoc)
	 * @see com.isse.service.JieQiService#findTjieqiById(java.lang.String)
	 */
	@Override
	public TJieqi findTjieqiById(String id) {
		return this.tJieqiDAO.findById(id);
	}

	@Override
	public List<TJieqi> findAllJieqis(String jqName,String jqYear,String jqQici,PageBean pageBean) {
		return this.tJieqiDAO.findAllJieqis(jqName, jqYear, jqQici, pageBean);
	}

	@Override
	public int findAllJieqicount(String jqName,String jqYear,String jqQici) {
		return this.tJieqiDAO.findAllJieqisCount(jqName, jqYear, jqQici);
	}

	@Override
	public void addJieqi(TJieqi jieqi) {
		Session session = this.tJieqiDAO.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			if(jieqi.getDeclarationState().equals("01")){
				String hql = "UPDATE TJieqi set declarationState='00' where declarationState='01'";
				Query query = session.createQuery(hql);
				query.executeUpdate();
			}
			if(jieqi.getEndprojectState().equals("01")){
				String hql2 = "UPDATE TJieqi set endprojectState='00' where endprojectState='01'";
				Query query2 = session.createQuery(hql2);
				query2.executeUpdate();
			}
			this.tJieqiDAO.save(jieqi);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	@Override
	public void updateJieqi(TJieqi jieqi) {
		Session session = this.tJieqiDAO.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			if(jieqi.getDeclarationState().equals("01")){
				String hql = "UPDATE TJieqi set declarationState='00' where declarationState='01'";
				Query query = session.createQuery(hql);
				query.executeUpdate();
			}
			if(jieqi.getEndprojectState().equals("01")){
				String hql2 = "UPDATE TJieqi set endprojectState='00' where endprojectState='01'";
				Query query2 = session.createQuery(hql2);
				query2.executeUpdate();
			}
			//this.tJieqiDAO.merge(jieqi);
			session.update(jieqi);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}	
	}

	@Override
	public void deleteJieqi(String jieqiId) {
		TJieqi t = this.tJieqiDAO.findById(jieqiId);
		t.setIsdeleted("Y");
		this.tJieqiDAO.merge(t);
	}

	@Override
	public List<BigDecimal> findAllYears() {
		return this.tJieqiDAO.findAllYears();
	}

	@Override
	public List<TJieqi> findJieqiByYear(String year) {
		return this.tJieqiDAO.getJieqiByYear(year);
	}

}
