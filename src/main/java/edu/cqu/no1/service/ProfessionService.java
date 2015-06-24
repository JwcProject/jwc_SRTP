package edu.cqu.no1.service;

import edu.cqu.no1.domain.TProfession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZKQ on 2015/6/4.
 */

public interface ProfessionService {
    public List<TProfession> findTProfessionsByTeaCode(String teaCode);

}
