/**
 * 
 */
package com.target.contentModerator.model;

import java.util.List;

/**
 * @author GowriKD
 *
 */
public class ReviewResult {
	
	String lang;
	List<String> blacklistedWords;
	
	
	/**
	 * @param lang
	 * @param blacklistedWords
	 */
	public ReviewResult(String lang, List<String> blacklistedWords) {
		super();
		this.lang = lang;
		this.blacklistedWords = blacklistedWords;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	/**
	 * @return the blacklistedWords
	 */
	public List<String> getBlacklistedWords() {
		return blacklistedWords;
	}
	/**
	 * @param blacklistedWords the blacklistedWords to set
	 */
	public void setBlacklistedWords(List<String> blacklistedWords) {
		this.blacklistedWords = blacklistedWords;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReviewResult [lang=" + lang + ", blacklistedWords=" + blacklistedWords + "]";
	}
	
	

}
