package com.javacase.sagar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacase.sagar.model.Course;
import com.javacase.sagar.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourseList(String topicId) {
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
			.forEach(courseList::add);
		return courseList;
	}

	public Course getCourseById(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
	}

	public void delteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
