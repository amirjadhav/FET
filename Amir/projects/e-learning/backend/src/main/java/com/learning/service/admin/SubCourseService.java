package com.learning.service.admin;

import java.util.List;
import java.util.Optional;

import com.learning.model.SubCourse;

public interface SubCourseService  {

    List<SubCourse> findAll();

    Optional<SubCourse> findById(int id);

    SubCourse save(SubCourse subCourse);

    SubCourse update(SubCourse subCourse);

    String deleteById(int id);

}
