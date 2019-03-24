/**
 * 
 */
package com.target.contentModerator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.target.contentModerator.model.BlacklistContent;
import com.target.contentModerator.model.ReviewResult;

/**
 * @author GowriKD
 *
 */
public class TestDataUtil {

	static public BlacklistContent b1 = new BlacklistContent("1","obj1","en");
	static public BlacklistContent b2 = new BlacklistContent("2","obj2","en");
	static public BlacklistContent b3 = new BlacklistContent("3","obj3","en");
	static public BlacklistContent b4 = new BlacklistContent("4","obj4","es");
	static public BlacklistContent b5 = new BlacklistContent("5","obj5","es");
	static public BlacklistContent b6 = new BlacklistContent("6","obj6","es");


	static public List<BlacklistContent> getTestDataList(){

		List<BlacklistContent> blacklistContentList = new ArrayList<BlacklistContent>();

		blacklistContentList.add(b1);
		blacklistContentList.add(b2);
		blacklistContentList.add(b3);
		blacklistContentList.add(b4);
		blacklistContentList.add(b5);
		blacklistContentList.add(b6);


		return blacklistContentList;

	}

	static public List<BlacklistContent> getTestDataListByLang(String lang){

		List<BlacklistContent> blacklistContentList = new ArrayList<BlacklistContent>();
		
		
		

		if(lang.equals("en")) {
			blacklistContentList.add(b1);
			blacklistContentList.add(b2);
			blacklistContentList.add(b3);
			
			
		}else if(lang.equals("es")) {
			blacklistContentList.add(b4);
			blacklistContentList.add(b5);
			blacklistContentList.add(b6);
		}

		return blacklistContentList;

	}

	static public List<String> getLangList(){

		List<String> langList = new ArrayList<String>();
		langList.add("en");
		langList.add("es");

		return langList;

	}
	
	static public String getTestUserContent(String lang) {
		
		String text="";
		
		
		
		if(lang.equals("en")) {
			text = "This comment includes some offensive text in english ob1 and ob2";;
		}else if(lang.equals("es")) {
			text= "This comment includes some offensive text in spanish ob4 and ob5";;
		}
		
		return text;
	}
	
	static public ReviewResult getTestUserContentReviewResult(String id) {
		ReviewResult rr =null;
		
		if(id.equals("1")) {
			rr = new ReviewResult("1","en",new ArrayList<String>( 
		            Arrays.asList("ob1", 
	                          "ob2"))); 
		}else if(id.equals("2")) {
			rr = new ReviewResult("1","es",new ArrayList<String>( 
		            Arrays.asList("ob4", 
	                          "ob5"))); 
		}
		
		return rr;
	}



}
