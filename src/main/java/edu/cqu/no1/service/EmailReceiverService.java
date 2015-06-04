package edu.cqu.no1.service;


import edu.cqu.no1.domain.TEmailReceiver;
import org.springframework.stereotype.Service;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface EmailReceiverService {
    public void saveEmailReceiver(TEmailReceiver tEmailReceiver);
}
