package edu.cqu.no1.dao;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */
public interface TEmailReceiverDAO {
    List findByReceiverCode(Object receiverCode);

    List findByReceiverRole(Object receiverRole);

    List findByEmailAddress(Object emailAddress);

    List findByIsReceived(Object isReceived);

    List findByIsdeleted(Object isdeleted);
}
