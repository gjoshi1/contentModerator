package com.target.contentModerator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BlacklistContent {

	@Id
	String id;

	String word;
	String lang;

	/**
	 * 
	 * @param word
	 * @param lang
	 * 
	 *//*
		 * public BlacklistContent(String word, String lang) {
		 * 
		 * this.word = word; this.lang = lang;
		 * 
		 * }
		 */

	/**
	 * @param id
	 * @param word
	 * @param lang
	 */
	public BlacklistContent(String id, String word, String lang) {

		this.id = id;
		this.word = word;
		this.lang = lang;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "BlackListContent [+id = " + id + " word=" + word + ", lang=" + lang + "]";
	}

}
