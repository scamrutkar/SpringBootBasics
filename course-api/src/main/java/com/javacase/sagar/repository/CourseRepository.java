package com.javacase.sagar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javacase.sagar.model.Course;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	public List<Course> findByTopicId(String topicId);

}
