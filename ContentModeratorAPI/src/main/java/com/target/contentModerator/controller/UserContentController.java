/**
 * 
 */
package com.target.contentModerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.contentModerator.model.ReviewResult;
import com.target.contentModerator.service.UserContentReviewService;

/**
 * @author Gowri Joshi
 *
 */
@RestController
public class UserContentController {
	
	@Autowired
	private UserContentReviewService userContentReviewService;
	
	
	@RequestMapping("/reviewContent")
	public @ResponseBody ReviewResult  reviewContent(@RequestParam String id,@RequestParam String content, @RequestParam String lang) {
		
		return userContentReviewService.reviewContent(id,content, lang);
	}
}
