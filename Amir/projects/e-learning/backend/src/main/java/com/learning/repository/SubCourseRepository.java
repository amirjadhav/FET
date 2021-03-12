package com.learning.repository;

import com.learning.model.SubCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCourseRepository extends JpaRepository<SubCourse,Integer> {

}
