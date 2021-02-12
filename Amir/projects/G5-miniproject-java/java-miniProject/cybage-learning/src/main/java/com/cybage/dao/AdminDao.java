package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.SubCourse;

public interface AdminDao  {
	public int addCategory(Category category) throws SQLException;
	public Category getCategoryById(int catId) throws SQLException;
	public List<Category> listCategory() throws SQLException;
	public int deleteCategory(int catId) throws SQLException;
	public int updateCategory(Category category) throws SQLException;
	
	public int addCourse(Course course) throws SQLException;
	public int updateCourse(Course course) throws SQLException;
	public int deleteCourse(int courseId) throws SQLException;
	public List<Course> listCourse(int catogoryId) throws SQLException;
	
	public int addSubCourse(SubCourse subcourse) throws SQLException;
	public int updateSubCourse(SubCourse subcourse) throws SQLException;
	public int deleteSubCourse(int subcourseId) throws SQLException;
	public List<SubCourse> listSubCourse(int courseId) throws SQLException;
}
