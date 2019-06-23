package com.javacase.sagar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javacase.sagar.model.Course;
import com.javacase.sagar.model.Topic;
import com.javacase.sagar.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@RequestMapping("/topic/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId){
		return service.getCourseList(topicId);
	}
	
	@RequestMapping("/topic/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable("id") String id,@PathVariable("topicId") String topicId) {
		return service.getCourseById(id);
	}
	
	@RequestMapping(value = "/topic/{topicId}/courses",method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course,@PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		service.addCourse(course);
	}
	
	@RequestMapping(value = "/topic/{topicId}/courses/{id}",method = RequestMethod.PUT)
	public void updateCourse(@PathVariable("id") String id, @PathVariable("topicId") String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId,"",""));
		service.updateCourse(id,course);
	}
	
	@RequestMapping(value = "/topic/{topicId}/courses/{id}",method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") String id, @PathVariable("topicId") String topicId) {
		service.delteCourse(id);
	}

}
