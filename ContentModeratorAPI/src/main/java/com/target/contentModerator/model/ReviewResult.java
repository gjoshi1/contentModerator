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
	
	String id;
	String lang;
	List<String> blacklistedWords;
	
	
	
	/**
	 * @param id
	 * @param lang
	 * @param blacklistedWords
	 */
	public ReviewResult(String id, String lang, List<String> blacklistedWords) {
		super();
		this.id = id;
		this.lang = lang;
		this.blacklistedWords = blacklistedWords;
	}
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
		return "ReviewResult [contentid=" + id + ", lang=" + lang + ", blacklistedWords=" + blacklistedWords + "]";
	}
	
	

}
