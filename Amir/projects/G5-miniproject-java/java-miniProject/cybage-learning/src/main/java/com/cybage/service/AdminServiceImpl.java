package com.cybage.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.AdminDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.SubCourse;

public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao;
	public static final Logger log =  LogManager.getLogger(AdminServiceImpl.class);
	
	public AdminServiceImpl(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}
	public int addCategory(Category category) throws SQLException{
		return adminDao.addCategory(category);
	}
	
	public Category getCategoryById(int catId) throws SQLException{
		return adminDao.getCategoryById(catId);
	}
	
	public List<Category> listCategory() throws SQLException{
		List<Category> newList = adminDao.listCategory();
		Collections.reverse(newList);
		return newList;
	}

	public int deleteCategory(int catId) throws SQLException{
		return adminDao.deleteCategory(catId);
	}
	
	public int updateCategory(Category category) throws SQLException{
		return adminDao.updateCategory(category);
	}
	
	public List<Course> listCourse(int catogoryId) throws SQLException{
		List<Course> newList = adminDao.listCourse(catogoryId);
		Collections.reverse(newList);
		return newList;
	}
	
	public int addCourse(Course course) throws SQLException{
		return adminDao.addCourse(course);
	}
	
	public int updateCourse(Course course) throws SQLException{
		return adminDao.updateCourse(course);
	}
	
	public int deleteCourse(int courseId) throws SQLException{
		return adminDao.deleteCourse(courseId);
	}

	// for subCourse
	public List<SubCourse> listSubCourse(int courseId) throws SQLException {
		List<SubCourse> newList = adminDao.listSubCourse(courseId);
		Collections.reverse(newList);
		return newList;
	}
	public int addSubCourse(SubCourse subcourse) throws SQLException{
		return adminDao.addSubCourse(subcourse);
	}
	public int deleteSubCourse(int subcourseId) throws SQLException{
		return adminDao.deleteSubCourse(subcourseId);
	}
	public int updateSubCourse(SubCourse subcourse) throws SQLException{
		return adminDao.updateSubCourse(subcourse);
	}
	
}
