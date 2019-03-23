/**
 * 
 */
package com.target.contentModerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.contentModerator.model.ReviewResult;

/**
 * @author Gowri Joshi
 *
 */
@Service
public class UserContentReviewService {

	@Autowired
	private BlacklistContentService blacklistContentService;
	
	public ReviewResult reviewContent(String content,String lang) {
		
		return new ReviewResult(lang,null);
		
	}
}
