package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;
import com.cybage.model.SubCourse;

public interface SubCourseDao {
	public List<SubCourse> findSubCourse() throws SQLException;
}
