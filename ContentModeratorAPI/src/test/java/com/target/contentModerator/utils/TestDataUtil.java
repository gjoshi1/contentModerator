/**
 * 
 */
package com.target.contentModerator.utils;

import java.util.ArrayList;
import java.util.List;

import com.target.contentModerator.model.BlacklistContent;

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
	

}
