package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;
import com.cybage.model.SubCourse;

public interface SubCourseDao {
	public List<SubCourse> findSubCourse() throws SQLException;

	public int getCurrentVideo(int courseid) throws SQLException;

	public int updateCurrentVideo(int userid, int courseid, int current_videoInDb) throws SQLException;
}
