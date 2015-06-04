package edu.cqu.no1.service.impl;

import edu.cqu.no1.dao.TProfessionDAO;
import edu.cqu.no1.domain.TProfession;
import edu.cqu.no1.service.ProfessionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

@Service
public class ProfessionServiceImpl implements ProfessionService {

    private TProfessionDAO tProfessionDAO;

    @Override
    public List<TProfession> findTProfessionsByTeaCode(String teaCode) {
        return this.tProfessionDAO.findProfessionsByTeaCode(teaCode);
    }

    public TProfessionDAO gettProfessionDAO() {
        return tProfessionDAO;
    }

    public void settProfessionDAO(TProfessionDAO tProfessionDAO) {
        this.tProfessionDAO = tProfessionDAO;
    }

}
