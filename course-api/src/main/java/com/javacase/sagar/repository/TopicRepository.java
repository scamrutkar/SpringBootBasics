package com.javacase.sagar.repository;

import org.springframework.data.repository.CrudRepository;

import com.javacase.sagar.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
