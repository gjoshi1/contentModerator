package com.target.contentModerator.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;


@Repository
public class BlacklistContentRepositoryImpl {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<String> findDistinctLanguages(){
		
	
		List<String> langList = new ArrayList<>();
		
	    MongoCollection mongoCollection = mongoTemplate.getCollection("blacklistContent");
	    DistinctIterable distinctIterable = mongoCollection.distinct("lang",String.class);
	    MongoCursor cursor = distinctIterable.iterator();
	    while (cursor.hasNext()) {
	        String lang = (String)cursor.next();
	        langList.add(lang);
	    }
	    
	    System.out.println(langList);
	    return langList;
	}
}
