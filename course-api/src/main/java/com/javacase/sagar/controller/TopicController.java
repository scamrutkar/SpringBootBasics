package com.javacase.sagar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javacase.sagar.model.Topic;
import com.javacase.sagar.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	TopicService service;
	
	@RequestMapping("/topic")
	public List<Topic> getAllTopics(){
		return service.getTopicsList();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return service.getTopicById(id);
	}
	
	@RequestMapping(value = "/topic",method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
	}
	
	@RequestMapping(value = "/topic/{id}",method = RequestMethod.PUT)
	public void updateTopic(@PathVariable("id") String id, @RequestBody Topic topic) {
		service.updateTopic(id,topic);
	}
	
	@RequestMapping(value = "/topic/{id}",method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable("id") String id) {
		service.delteTopic(id);
	}
	
}
