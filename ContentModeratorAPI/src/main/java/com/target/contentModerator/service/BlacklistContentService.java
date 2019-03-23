/**
 * 
 */
package com.target.contentModerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.contentModerator.model.BlacklistContent;
import com.target.contentModerator.repository.BlacklistContentRepository;

/**
 * @author Gowri Joshi
 *
 */
/**
 * @author GowriKD
 *
 */
@Service
public class BlacklistContentService {
	
	@Autowired
	private BlacklistContentRepository blacklistContentRepository;
	
	
	public BlacklistContent create(String word, String lang) {
		
		return blacklistContentRepository.save(new BlacklistContent(word, lang));
		
	}
	
	public BlacklistContent update(BlacklistContent blackListContent) {
		
		return blacklistContentRepository.save(blackListContent);
		
	}
	
	public void deleteAll() {
		blacklistContentRepository.deleteAll();
	}
	
	public void delete(BlacklistContent blackListContent) {
		blacklistContentRepository.delete(blackListContent);
	}
	
	
	public List<BlacklistContent> getAllBlackListContent(){
		return blacklistContentRepository.findAll();
	}
	

	public List<BlacklistContent> getAllBlackListContentByLang(String lang){
		
		return blacklistContentRepository.findByLang(lang);
		
		
	}
	
	
	
}
