package edu.cqu.no1.service.impl;


import edu.cqu.no1.dao.TEmailDAO;
import edu.cqu.no1.dao.TEmailReceiverDAO;
import edu.cqu.no1.domain.TEmail;
import edu.cqu.no1.service.EmailService;
import org.springframework.stereotype.Service;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class EmailServiceImpl implements EmailService {
    TEmailDAO tEmailDAO;
    TEmailReceiverDAO tEmailReceiverDAO;


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
