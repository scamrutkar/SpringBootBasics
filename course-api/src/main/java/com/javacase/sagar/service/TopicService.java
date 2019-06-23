package com.javacase.sagar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacase.sagar.model.Topic;
import com.javacase.sagar.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getTopicsList() {
		List<Topic> topicList = new ArrayList<>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}

	public Topic getTopicById(String id) {
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void delteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
