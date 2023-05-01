package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.dao.StandardDao;
import com.exam.entity.Standard;


public interface StandardService {
	public Standard addStandard(StandardDao standardDao);
	public Standard updateStandard(StandardDao standardDao,Long standardId);
	public List<Standard> getStandard();
	public Standard getStandardById(Long standardId);
	public void deleteStandardById(Long standardId);
	public Long countStandard(Standard standard);
}
