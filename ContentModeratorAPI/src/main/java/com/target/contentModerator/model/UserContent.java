/**
 * 
 */
package com.target.contentModerator.model;

/**
 * @author GowriKD
 *
 */
public class UserContent {
	
	String id;
	String lang;
	String content;
	
	
	/**
	 * @param id
	 * @param lang
	 * @param content
	 */
	public UserContent(String id, String lang, String content) {
		super();
		this.id = id;
		this.lang = lang;
		this.content = content;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
