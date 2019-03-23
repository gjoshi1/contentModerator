package com.target.contentModerator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.target.contentModerator.model.BlacklistContent;

@Repository
public interface BlacklistContentRepository extends MongoRepository<BlacklistContent,String>{
	
	public List<BlacklistContent> findByLang(String lang);
	
	
	
}
