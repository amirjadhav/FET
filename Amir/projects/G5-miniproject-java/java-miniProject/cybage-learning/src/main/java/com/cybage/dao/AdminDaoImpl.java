package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.controller.UserController;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.SubCourse;
import com.cybage.util.DbUtil;


public class AdminDaoImpl implements AdminDao{
	
	public static final Logger log =  LogManager.getLogger(AdminDaoImpl.class);
//-----------------------------------------------add category------------------------------------------------------------------
	public int addCategory(Category category) throws SQLException {
		String sql = "insert into category(category_name, image_url) values(?, ?)";
		log.debug(" data inserted in category table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,category.getCategoryName());
		ps.setString(2,category.getImageUrl());
		return ps.executeUpdate();
	}
//-----------------------------------------------get category by id------------------------------------------------------------------
	public Category getCategoryById(int catId) throws SQLException {
		String sql = "select * from category where category_id = ?";
		log.debug(" data retrieved from category table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, catId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Category category = new Category();
		category.setCategoryId(rs.getInt(1));
		category.setCategoryName(rs.getString(2));
		category.setImageUrl(rs.getString(3));
		return category;
	}
//-----------------------------------------------list category------------------------------------------------------------------	
	public List<Category> listCategory() throws SQLException{
		
		String sql = "select category_id, category_name, image_url from category";
		log.debug(" data retrieved from category table ");
		Connection con = DbUtil.getCon();
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
//-----------------------------------------------delete category------------------------------------------------------------------	
	public int deleteCategory(int catId) throws SQLException {
		String sql = "delete from category where category_id = ?";
		log.debug(" data deleted from category table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, catId);
		return ps.executeUpdate();
	}
//-----------------------------------------------update category------------------------------------------------------------------	
	public int updateCategory(Category category) throws SQLException{
		String sql = "update category set category_name = ? , image_url = ? where category_id = ?";
		log.debug(" data updated in category table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category.getCategoryName());
		ps.setString(2, category.getImageUrl());
		ps.setInt(3, category.getCategoryId());
		return ps.executeUpdate();
	}
//-----------------------------------------------list course------------------------------------------------------------------	
	public List<Course> listCourse(int categoryId) throws SQLException{
		String sql = "select course_id, course_name, course_price, course_duration, course_author, course_description, image_url from course where category_id = ?";
		log.debug(" data retrieved from course table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, categoryId);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt(1));
			course.setCourseName(rs.getString(2));
			course.setCoursePrice(rs.getInt(3));
			course.setCourseDuration(rs.getInt(4));
			course.setCourseAuthor(rs.getString(5));
			course.setCourseDescription(rs.getString(6));
			course.setImageUrl(rs.getString(7));
			course.setCategoryId(categoryId);
			courses.add(course);
		}
		return courses;
	}
//-----------------------------------------------add course------------------------------------------------------------------	
	public int addCourse(Course course) throws SQLException{
		String sql = "insert into course(course_name, course_price, course_duration, course_author, course_description, total_sub_course, image_url, category_id) values(?, ?, ?, ?, ?, ?, ?, ?)";
		log.debug(" data inserted in course table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,course.getCourseName());
		ps.setInt(2,course.getCoursePrice());
		ps.setInt(3,course.getCourseDuration());
		ps.setString(4,course.getCourseAuthor());
		ps.setString(5,course.getCourseDescription());
		ps.setInt(6,course.getTotalSubCourse());
		ps.setString(7,course.getImageUrl());
		ps.setInt(8,course.getCategoryId());
		return ps.executeUpdate();
	}
//-----------------------------------------------update course------------------------------------------------------------------	
	public int updateCourse(Course course) throws SQLException{
		String sql = "update course set course_name = ? , course_price = ?, course_duration = ?, course_author = ?, course_description = ?, total_sub_course = ?, image_url = ? where course_id = ?";
		log.debug(" data updated in course table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,course.getCourseName());
		ps.setInt(2,course.getCoursePrice());
		ps.setInt(3,course.getCourseDuration());
		ps.setString(4,course.getCourseAuthor());
		ps.setString(5,course.getCourseDescription());
		ps.setInt(6,course.getTotalSubCourse());
		ps.setString(7,course.getImageUrl());
		ps.setInt(8, course.getCourseId());
		return ps.executeUpdate();
	}
//-----------------------------------------------delete course------------------------------------------------------------------	
	public int deleteCourse(int courseId) throws SQLException{
		String sql = "delete from course where course_id = ?";
		log.debug(" data deleted from course table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseId);
		return ps.executeUpdate();
	}

//-----------------------------------------------list subCourse------------------------------------------------------------------
	
	public List<SubCourse> listSubCourse(int courseId) throws SQLException{
		String sql = "select sub_course_id, sub_course_name, sub_course_duration, sub_course_description, video_url, video_sequence, course_id from sub_course where course_id =?";
		log.debug(" data retrieved from subCourse table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, courseId);
	
		ResultSet rs = ps.executeQuery();

		List<SubCourse> subcourses = new ArrayList<SubCourse>();
		while (rs.next()) {
			SubCourse subcourse = new SubCourse();
			subcourse.setSubCourseId(rs.getInt(1));
			subcourse.setSubCourseName(rs.getString(2));
			subcourse.setSubCourseDuration(rs.getInt(3));
			subcourse.setSubCourseDescription(rs.getString(4));
			subcourse.setVideoUrl(rs.getString(5));
			subcourse.setVideoSequence(rs.getInt(6));
			subcourse.setCourseId(courseId);
			subcourses.add(subcourse);
		}
		return subcourses;
	}
//-----------------------------------------------add subCourse------------------------------------------------------------------	
	public int addSubCourse(SubCourse subcourse) throws SQLException{
		String sql = "insert into sub_course(sub_course_name, sub_course_duration, sub_course_description, video_url, video_sequence, course_id) values(?, ?, ?, ?, ?, ?)";
		log.debug(" data inserted in subCourse table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,subcourse.getSubCourseName());
		ps.setInt(2,subcourse.getSubCourseDuration());
		ps.setString(3,subcourse.getSubCourseDescription());
		ps.setString(4,subcourse.getVideoUrl());
		ps.setInt(5,subcourse.getVideoSequence());
		ps.setInt(6,subcourse.getCourseId());
	
		return ps.executeUpdate();
	}
//-----------------------------------------------delete subCourse------------------------------------------------------------------	
	public int deleteSubCourse(int subcourseId) throws SQLException{
		String sql = "delete from sub_course where sub_course_id = ?";
		log.debug(" data deleted from subCourse table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, subcourseId);
		return ps.executeUpdate();
	}
//-----------------------------------------------update subCourse------------------------------------------------------------------
	public int updateSubCourse(SubCourse subcourse) throws SQLException{
		String sql = "update sub_course set sub_course_name = ? , sub_course_duration = ?, sub_course_description = ?, video_url = ?, video_sequence = ? where sub_course_id = ?";
		log.debug(" data updated in subCourse table ");
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,subcourse.getSubCourseName());
		ps.setInt(2,subcourse.getSubCourseDuration());
		ps.setString(3,subcourse.getSubCourseDescription());
		ps.setString(4,subcourse.getVideoUrl());
		ps.setInt(5,subcourse.getVideoSequence());
		ps.setInt(6,subcourse.getSubCourseId());
		
		return ps.executeUpdate();
	}
}
