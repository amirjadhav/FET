package com.learning.service.admin;

import java.util.List;
import java.util.Optional;

import com.learning.model.SubCourse;
import com.learning.repository.SubCourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SubCourseServiceImpl implements SubCourseService {

    @Autowired
    SubCourseRepository subCourseRepository;

    @Override
    public List<SubCourse> findAll() {

        return subCourseRepository.findAll();
    }

    @Override
    public Optional<SubCourse> findById(int id) {
        return subCourseRepository.findById(id);
    }

    @Override
    public SubCourse save(SubCourse subCourse) {
        return subCourseRepository.save(subCourse);
    }

    @Override
    public SubCourse update(SubCourse subCourse) {
        return subCourseRepository.save(subCourse);
    }

    @Override
    public String deleteById(int id) {
        try {
            subCourseRepository.deleteById(id);
            return "SubCourse deleted..";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCourse not deleted", e);
        }
    }

}
