package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;


public interface UserDao {
	public List<Category> findCategory() throws Exception;
	public List<Category> searchByCategory(String searchString) throws SQLException;
	public List<Course> searchByCourse(String searchString) throws SQLException;
}
