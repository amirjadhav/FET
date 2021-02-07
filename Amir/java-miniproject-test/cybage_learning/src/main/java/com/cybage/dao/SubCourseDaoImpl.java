package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.SubCourse;
import com.cybage.util.DbUtil;

public class SubCourseDaoImpl implements SubCourseDao {

	public List<SubCourse> findSubCourse() throws SQLException {
		Connection con = DbUtil.getCon();

		String sql = "select sub_course_id, sub_course_name, sub_course_duration, sub_course_description, video_url, video_sequence, course_id from sub_course";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<SubCourse> subCourses = new ArrayList<SubCourse>();
		while (rs.next()) {
			SubCourse subCourse = new SubCourse();

			subCourse.setSubCourseId(rs.getInt(1));
			subCourse.setSubCourseName(rs.getString(2));
			subCourse.setSubCourseDuration(rs.getInt(3));
			subCourse.setSubCourseDescription(rs.getString(4));
			subCourse.setVideoUrl(rs.getString(5));
			subCourse.setVideoSequence(rs.getInt(6));
			subCourse.setCourseId(rs.getInt(7));

			subCourses.add(subCourse);
			
		}
		return subCourses;
	}
}
