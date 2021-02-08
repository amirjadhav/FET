package com.cybage.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.util.DbUtil;

public class UserDaoImpl implements UserDao {
	
	
	public List<Category> findCategory() throws Exception {
		Connection con = DbUtil.getCon();

		String sql = "select category_id, category_name, image_url from category";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setCategoryId(rs.getInt(1));
			category.setCategoryName(rs.getString(2));
			category.setImageUrl(rs.getString(3));

			categories.add(category);
		}
		return categories;
	}

	//-----------------search category-----------------------------------------------------------
		public List<Category> searchByCategory(String searchString) throws SQLException {
			Connection connection = DbUtil.getCon();
			String sql = "select * from category where category_name LIKE ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + searchString + "%");
			ResultSet rs = ps.executeQuery();       //throw an exception if result set is less then 0
			List<Category> categoryList = new ArrayList<Category>();
		
			while(rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setImageUrl(rs.getString(3));
				categoryList.add(category);
			}
			return categoryList;
			
		}
		
		
	//-----------------------------search course--------------------------------------------------------
		public List<Course> searchByCourse(String searchString) throws SQLException {
			Connection connection = DbUtil.getCon();
			String sql = "select * from course where course_name LIKE ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + searchString + "%");
			ResultSet rs = ps.executeQuery();     //throw an exception if result set is less then 0
			List<Course> courseList = new ArrayList<Course>();
		
			while(rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setCoursePrice(rs.getInt(3));
				course.setCourseDuration(rs.getInt(4));
				course.setCourseAuthor(rs.getString(5));
				course.setCourseDescription(rs.getString(6));
				course.setImageUrl(rs.getString(7));
				
				courseList.add(course);
			}
			return courseList;
		}


}
