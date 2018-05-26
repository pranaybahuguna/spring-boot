package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring","Spring","Spring Description"),
			new Topic("java","Java","Java Description"),
			new Topic("javascript","JavaScript","JavaScripts Description")
			));

	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void createTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
        for(int i = 0 ; i < topics.size() ; i++) {
        	if(topics.get(i).getId().equals(id)) {
        		topics.set(i,topic);
        	}
        }		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));	
	}

}
