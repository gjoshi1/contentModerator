/**
 * 
 */
package com.target.contentModerator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.target.contentModerator.model.BlacklistContent;
import com.target.contentModerator.model.ReviewResult;
import com.target.contentModerator.model.UserContent;

/**
 * @author Gowri Joshi
 *
 */
@Service
public class UserContentReviewService {

	@Autowired
	private BlacklistContentService blacklistContentService;

	public ReviewResult reviewContent(UserContent userContent) {

		List<BlacklistContent> blackListContent = new ArrayList<BlacklistContent>();


		if(!StringUtils.isEmpty(userContent.getLang())) {

			blackListContent = blacklistContentService.getAllBlackListContentByLang(userContent.getLang());

		}else {
			blackListContent = blacklistContentService.getAllBlackListContent();
		}

		ReviewResult res = new ReviewResult(userContent.getId(),userContent.getLang(),reviewContent(userContent.getContent(),blackListContent));

		return res;

	}

	private List<String> reviewContent(String content, List<BlacklistContent> blackListContent) {

		content = content.toLowerCase();

		List<String> badWordsInContent = new ArrayList<String>();

		for(BlacklistContent word : blackListContent) {
			if(content.indexOf(word.getWord()) > 0 ) {
				badWordsInContent.add(word.getWord());
			}
		}

		return badWordsInContent;
	}

}
