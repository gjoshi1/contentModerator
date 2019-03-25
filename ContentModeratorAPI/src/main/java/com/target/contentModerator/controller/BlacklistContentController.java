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
 * This class is REST controller for BlacklistContent CRUD operations.
 *
 */
@RestController
public class BlacklistContentController {
	
	/**
	 * TODO :
	 
	 * documentation
	 * 
	 * */
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	 
	
	@Autowired
	private BlacklistContentService blacklistContentService;
	
	/**
	 * CREATE
	 * @param word
	 * @param lang
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/create")
	public String create(@RequestParam String word, @RequestParam String lang) throws Exception {
		
		if(StringUtils.isEmpty(word) || StringUtils.isEmpty(lang)) {
			throw new IllegalArgumentException("Empty Word or Language parameter");
		}
		
		BlacklistContent blc = blacklistContentService.create(word, lang);
		
		LOGGER.info("CREATED BLACKLIST ENTRY "+blc.toString());
		
		return blc.toString();
	}
	/**
	 * UPDATE
	 * @param blackListContent
	 * @return
	 */
	@RequestMapping("/update")
	public String update(@RequestBody BlacklistContent blackListContent) {
		
		
		
		if(StringUtils.isEmpty(blackListContent.getId())) {
			throw new IllegalArgumentException("Missing ID, cannot update document");
		}
		
		BlacklistContent bc = blacklistContentService.update(blackListContent);
		
		LOGGER.info("UPDATED BLACKLIST ENTRY "+bc.toString());
		
		return bc.toString();
	}
	
	/**
	 * GET Blacllist content for ALL languages
	 * @return
	 */
	@RequestMapping("/getAll")
	public List<BlacklistContent>  getAll() {
		
		return blacklistContentService.getAllBlackListContent();
	}
	
	/**
	 * Gets list of supported languages
	 * @return
	 */
	@RequestMapping("/getSupportedLanguages")
	public List<String>  getAllLanguages() {
		
		return blacklistContentService.getSupportedLanguages();
	}
	/**
	 * Gets list of blacklistcontent filtered by language
	 * @param lang
	 * @return
	 */
	@RequestMapping("/getAllBlacklistContentByLang")
	public List<BlacklistContent>  getAllBlacklistContentByLang(@RequestParam String lang) {
		
		return blacklistContentService.getAllBlackListContentByLang(lang);
	}
	
	
	/**
	 * Deletes all entries for blacklistcontent
	 */
	@RequestMapping("/deleteAll")
	public void deleteAll() {
		
		blacklistContentService.deleteAll();
	}

	/**
	 * Deletes blacklistcontent by id
	 * @param id
	 */
	@RequestMapping("/delete")
	public void delete(@RequestParam String id) {
		
		if(StringUtils.isEmpty(id.trim()) ){
			throw new IllegalArgumentException("Missing ID, cannot delete document!");
		}
		blacklistContentService.delete(id);
	}
	
	/**
	 * Global exception handler
	 * @param response
	 * @throws IOException
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	void handleBadRequests(HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
