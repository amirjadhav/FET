package com.cybage.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.AdminDao;
import com.cybage.dao.AdminDaoImpl;
import com.cybage.exception.UserException;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.SubCourse;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final Logger log =  LogManager.getLogger(AdminController.class);
	AdminDao adminDao = new AdminDaoImpl();
	AdminService adminService = new AdminServiceImpl(adminDao);
		
				
	public AdminController() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String path = request.getPathInfo();
		
		//For adding a category.
		if (path.equals("/addCategory")) {
			log.debug("inside add method....");
			String categoryName = request.getParameter("categoryName");
			String imageUrl = request.getParameter("imageUrl");
			Category category = new Category(categoryName, imageUrl);
			try {
				int addCount = adminService.addCategory(category);
				if (addCount <= 0) {
					throw new UserException("Could not add category.");
				}
				request.getRequestDispatcher("listCategory").forward(request, response);

			} catch (SQLException e) {
//				log.error("exception occurred... " + e.getLocalizedMessage());
				System.out.println(e.getLocalizedMessage());
			}
			catch (UserException u) {
//				log.error("exception occurred... " + e.getLocalizedMessage());
				System.out.println(u.getLocalizedMessage());
			}
		}
		
		//For listing all the categories on admin page.
		if (path.equals("/listCategory")) {
			System.out.println("Inside listcategory");
			try {
				List<Category> categories = adminService.listCategory();
				request.setAttribute("cat", categories);
				request.getRequestDispatcher("/admin/listCategory.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
		
		//For deleting a category.
		if (path.equals("/deleteCategory")) {
			System.out.println("Inside deleteCategory....");
				try {
					int catId = Integer.parseInt(request.getParameter("id"));
					//System.out.println("catId:" + catId);
					int del = adminService.deleteCategory(catId);
					//System.out.println("catname: " + category.getCategoryName());
				    if(del < 0 ) {
						throw new UserException("could not get given category.");
					}	
					
					request.getRequestDispatcher("listCategory").forward(request, response);

				} catch (SQLException  e) {
//					log.error("exception occurred... " + e.getLocalizedMessage());
					System.out.println(e.getLocalizedMessage());
				} catch(NumberFormatException e) {
					System.out.println(e.getLocalizedMessage());
				} catch (UserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		//For updating a category.
				if (path.equals("/updateCategory")) {
					System.out.println("inside update method....");
					int categoryId = Integer.parseInt(request.getParameter("categoryId"));
					String categoryName = request.getParameter("categoryName");
					String imageUrl = request.getParameter("imageUrl");
					Category category = new Category(categoryId, categoryName, imageUrl);
					try {
						int addCount = adminService.updateCategory(category);
						if (addCount <= 0) {
							throw new UserException("Could not update category.");
						}
						request.getRequestDispatcher("listCategory").forward(request, response);

					} catch (SQLException e) {
//						log.error("exception occurred... " + e.getLocalizedMessage());
						System.out.println(e.getLocalizedMessage());
					} catch (UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
				
				//For Courses
				
				
				//For adding a course.
				if (path.equals("/addCourse")) {
					System.out.println("inside course add method....");
					int categoryId = Integer.parseInt(request.getParameter("cid"));
					String courseName = request.getParameter("courseName");
					int coursePrice = Integer.parseInt(request.getParameter("coursePrice"));
					int courseDuration = Integer.parseInt(request.getParameter("courseDuration"));
					String courseAuthor = request.getParameter("courseAuthor");
					String courseDescription = request.getParameter("courseDescription");
					int totalSubCourse = Integer.parseInt(request.getParameter("totalSubCourse"));
					String imageUrl = request.getParameter("imageUrl");
					Course course = new Course(courseName, courseAuthor, courseDescription,  imageUrl, courseDuration, coursePrice, totalSubCourse, categoryId);
					try {
						int addCount = adminService.addCourse(course);
						if (addCount <= 0) {
							throw new UserException("Could not add course.");
						}
						request.getRequestDispatcher("listCourse").forward(request, response);

					} catch (SQLException e) {
//						log.error("exception occurred... " + e.getLocalizedMessage());
						System.out.println(e.getLocalizedMessage());
					} catch (UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//For listing all the courses on admin page.
				if (path.equals("/listCourse")) {
					System.out.println("Inside listcourse");
					try {
						int categoryId = Integer.parseInt(request.getParameter("cid"));
						List<Course> courses = adminService.listCourse(categoryId);
						request.setAttribute("courses", courses);
						request.setAttribute("categoryId", categoryId);
						request.getRequestDispatcher("/admin/listCourse.jsp").forward(request, response);

					} catch (Exception e) {
						System.out.println("error occurred: " + e.getMessage());
					}
				}
				
				//For updating a course.
				if (path.equals("/updateCourse")) {
					System.out.println("inside update method....");
					int courseId = Integer.parseInt(request.getParameter("courseId"));
					String courseName = request.getParameter("courseName");
					int coursePrice = Integer.parseInt(request.getParameter("coursePrice"));
					int courseDuration = Integer.parseInt(request.getParameter("courseDuration"));
					String courseAuthor = request.getParameter("courseAuthor");
					String courseDescription = request.getParameter("courseDescription");
					int totalSubCourse = Integer.parseInt(request.getParameter("totalSubCourse"));
					String imageUrl = request.getParameter("imageUrl");
					Course course = new Course(courseId , courseName, courseAuthor, courseDescription, imageUrl, courseDuration, coursePrice, totalSubCourse);
					try {
						int addCount = adminService.updateCourse(course);
						if (addCount <= 0) {
							throw new UserException("Could not update course.");
						}
						request.getRequestDispatcher("listCourse").forward(request, response);

					} catch (SQLException e) {
//						log.error("exception occurred... " + e.getLocalizedMessage());
						System.out.println(e.getLocalizedMessage());
					} catch (UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				
				//For deleting a course.
				if (path.equals("/deleteCourse")) {
					System.out.println("Inside deleteCourse....");
						try {
							int courseId = Integer.parseInt(request.getParameter("id"));
							int del = adminService.deleteCourse(courseId);
						    if(del < 0 ) {
								throw new UserException("could not get given course.");
							}	
							request.getRequestDispatcher("listCourse").forward(request, response);
						} catch (SQLException  e) {
//							log.error("exception occurred... " + e.getLocalizedMessage());
							System.out.println(e.getLocalizedMessage());
						} catch(NumberFormatException e) {
							System.out.println(e.getLocalizedMessage());
						} catch (UserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				//For listing all the Subcourses on admin page.
				if (path.equals("/listSubCourse")) {
					System.out.println("Inside list of Subcourses");
					try {
						int courseId = Integer.parseInt(request.getParameter("coid"));
						List<SubCourse> subcourses = adminService.listSubCourse(courseId);
						request.setAttribute("subcourses", subcourses);
						request.setAttribute("courseId", courseId);
						
						request.getRequestDispatcher("/admin/listSubCourse.jsp").forward(request, response);

					} catch (Exception e) {
						System.out.println("error occurred: " + e.getMessage());
					}
				}
				//For Adding all the SubCourses
				
				if (path.equals("/addSubCourse")) {
					System.out.println("inside subcourse add method....");
					int courseId = Integer.parseInt(request.getParameter("coid"));
					String subCourseName = request.getParameter("subCourseName");
					int subCourseDuration = Integer.parseInt(request.getParameter("subCourseDuration"));
					String subCourseDescription = request.getParameter("subCourseDescription");
					String videoUrl = request.getParameter("videoUrl");
					int videoSeq = Integer.parseInt(request.getParameter("videoSeq"));
					
					
					SubCourse subCourse = new SubCourse(subCourseDuration, courseId, subCourseName, subCourseDescription, videoUrl, videoSeq);
					try {
						int addCount = adminService.addSubCourse(subCourse);
						if (addCount <= 0) {
							throw new UserException("Could not add course.");
						}
						request.getRequestDispatcher("listSubCourse").forward(request, response);

					} catch (SQLException e) {
//						log.error("exception occurred... " + e.getLocalizedMessage());
						System.out.println(e.getLocalizedMessage());
					} catch (UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//For deleting Subcourse.
				if (path.equals("/deleteSubCourse")) {
					System.out.println("Inside delete SubCourse....");
						try {
							int subcourseId = Integer.parseInt(request.getParameter("scid"));
							int del = adminService.deleteSubCourse(subcourseId);
						    if(del < 0 ) {
								throw new UserException("could not get given course.");
							}	
							request.getRequestDispatcher("listSubCourse").forward(request, response);
						} catch (SQLException  e) {
//							log.error("exception occurred... " + e.getLocalizedMessage());
							System.out.println(e.getLocalizedMessage());
						} catch(NumberFormatException e) {
							System.out.println(e.getLocalizedMessage());
						} catch (UserException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				

				//For updating Subcourse.
				if (path.equals("/updateSubCourse")) {
					System.out.println("inside update method of Subcourse....");
					int courseId = Integer.parseInt(request.getParameter("cid"));
					int subCourseId = Integer.parseInt(request.getParameter("subcourseId"));
					String subCourseName = (request.getParameter("scname"));
					int subCourseDuration = Integer.parseInt(request.getParameter("scduration"));
					String subCourseDescription =request.getParameter("scdescription");
					String videoUrl = request.getParameter("scvideourl");
					int videoSequence = Integer.parseInt(request.getParameter("scvideoseq"));
					
					SubCourse subcourse = new SubCourse(subCourseId, subCourseDuration, courseId, subCourseName, subCourseDescription, videoUrl, videoSequence);
					try {
						int addCount = adminService.updateSubCourse(subcourse);
						if (addCount <= 0) {
							throw new UserException("Could not update sub course.");
						}
						request.getRequestDispatcher("listSubCourse").forward(request, response);

					} catch (SQLException e) {
//						log.error("exception occurred... " + e.getLocalizedMessage());
						System.out.println(e.getLocalizedMessage());
					} catch (UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
