/**
 * 
 */
package com.target.contentModerator.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.target.contentModerator.model.BlacklistContent;
import com.target.contentModerator.service.BlacklistContentService;

/**
 * @author Gowri Joshi
 *
 */
@RestController
public class BlacklistContentController {
	
	/**
	 * TODO :
	 * Logging
	 * input validation
	 * error handling
	 * documentation
	 * 
	 * */
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	 
	
	@Autowired
	private BlacklistContentService blacklistContentService;
	
	
	@RequestMapping("/create")
	public String create(@RequestParam String word, @RequestParam String lang) throws Exception {
		
		if(StringUtils.isEmpty(word) || StringUtils.isEmpty(lang)) {
			throw new IllegalArgumentException("Empty Word or Language parameter");
		}
		
		BlacklistContent blc = blacklistContentService.create(word, lang);
		
		LOGGER.info("CREATED BLACKLIST ENTRY "+blc.toString());
		return blc.toString();
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody BlacklistContent blackListContent) {
		
		
		
		if(StringUtils.isEmpty(blackListContent.getId())) {
			throw new IllegalArgumentException("Missing ID, cannot update document");
		}
		
		
		return blacklistContentService.update(blackListContent).toString();
	}
	
	
	@RequestMapping("/getAll")
	public List<BlacklistContent>  getAll() {
		
		return blacklistContentService.getAllBlackListContent();
	}
	
	@RequestMapping("/getSupportedLanguages")
	public List<String>  getAllLanguages() {
		
		return blacklistContentService.getSupportedLanguages();
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
	public void delete(@RequestParam String id) {
		
		if(StringUtils.isEmpty(id.trim()) ){
			throw new IllegalArgumentException("Missing ID, cannot delete document!");
		}
		blacklistContentService.delete(id);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	void handleBadRequests(HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
