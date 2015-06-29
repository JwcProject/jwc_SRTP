/**
 * 
 */
package com.isse.service;

import java.util.List;

import com.isse.model.TProfession;

/**
 * @author ming
 *
 */
public interface ProfessionService {
	public List<TProfession> findTProfessionsByTeaCode(String teaCode);

}
