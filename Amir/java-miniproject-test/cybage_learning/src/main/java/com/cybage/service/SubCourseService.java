package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.SubCourse;

public interface SubCourseService {
	public List<SubCourse> findSubCourse() throws SQLException;
}
