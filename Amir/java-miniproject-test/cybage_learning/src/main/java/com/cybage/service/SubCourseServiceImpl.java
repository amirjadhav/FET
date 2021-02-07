package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.SubCourseDao;
import com.cybage.model.SubCourse;

public class SubCourseServiceImpl implements SubCourseService {
	public static final Logger log = LogManager.getLogger(SubCourseServiceImpl.class);
	private SubCourseDao subCourseDao;

	public SubCourseServiceImpl(SubCourseDao subCourseDao) {
		this.subCourseDao = subCourseDao;
	}

	public List<SubCourse> findSubCourse() throws SQLException {
		log.debug("inside find user...");
		return subCourseDao.findSubCourse();
	}

}
