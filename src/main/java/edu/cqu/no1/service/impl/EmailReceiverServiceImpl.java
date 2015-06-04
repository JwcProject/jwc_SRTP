package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TEmailReceiverDAO;
import edu.cqu.no1.domain.TEmailReceiver;
import edu.cqu.no1.service.EmailReceiverService;
import org.springframework.stereotype.Service;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class EmailReceiverServiceImpl implements EmailReceiverService {
    TEmailReceiverDAO tEmailReceiverDAO;


    @Override
    public void saveEmailReceiver(TEmailReceiver tEmailReceiver) {
        this.tEmailReceiverDAO.save(tEmailReceiver);
    }

    public TEmailReceiverDAO gettEmailReceiverDAO() {
        return tEmailReceiverDAO;
    }

    public void settEmailReceiverDAO(TEmailReceiverDAO tEmailReceiverDAO) {
        this.tEmailReceiverDAO = tEmailReceiverDAO;
    }

}
