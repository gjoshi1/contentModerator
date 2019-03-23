/**
 * 
 */
package com.target.contentModerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.target.contentModerator.model.BlacklistContent;
import com.target.contentModerator.repository.BlacklistContentRepository;
import com.target.contentModerator.service.BlacklistContentService;

/**
 * @author Gowri Joshi
 *
 */
@RestController
public class BlacklistContentController {
	
	@Autowired
	private BlacklistContentService blacklistContentService;
	
	
	@RequestMapping("/create")
	public String create(@RequestParam String word, @RequestParam String lang) {
		
		BlacklistContent blc = blacklistContentService.create(word, lang);
		return blc.toString();
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody BlacklistContent blackListContent) {
		
		return blacklistContentService.update(blackListContent).toString();
	}
	
	
	@RequestMapping("/getAll")
	public List<BlacklistContent>  getAll() {
		
		return blacklistContentService.getAllBlackListContent();
	}
	
	@RequestMapping("/getAllBlacklistContentByLang")
	public List<BlacklistContent>  getAllBlacklistContentByLang(@RequestParam String lang) {
		
		return blacklistContentService.getAllBlackListContentByLang(lang);
	}
	
	
	
	@RequestMapping("/deleteAll")
	public void deleteAll() {
		
		blacklistContentService.deleteAll();
	}

	@RequestMapping("/delete")
	public void delete(@RequestParam BlacklistContent blackListContent) {
		
		blacklistContentService.delete(blackListContent);
	}

}
