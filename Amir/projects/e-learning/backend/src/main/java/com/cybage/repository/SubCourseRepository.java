package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.SubCourse;

@Repository
public interface SubCourseRepository extends JpaRepository<SubCourse,Integer> {

}
