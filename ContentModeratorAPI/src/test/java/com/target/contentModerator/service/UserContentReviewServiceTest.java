package com.target.contentModerator.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.contentModerator.ContentModeratorApiApplication;
import com.target.contentModerator.model.BlacklistContent;
import com.target.contentModerator.model.ReviewResult;
import com.target.contentModerator.repository.BlacklistContentRepository;
import com.target.contentModerator.utils.TestDataUtil;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ContentModeratorApiApplication.class)
public class UserContentReviewServiceTest {
	
	@InjectMocks private UserContentReviewService userContentReviewService;
	@Mock private BlacklistContentService blacklistContentService;
	//@Mock private BlacklistContentRepository blacklistContentRepository;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReviewContent() {
		
		String txt = TestDataUtil.getTestUserContent("en");
		
		//List<BlacklistContent> bcList = TestDataUtil.getTestDataListByLang("en");
		//Mockito.when(blacklistContentRepository.findByLang("en")).thenReturn(bcList);
	
		BlacklistContent b1 =  TestDataUtil.b1;
		BlacklistContent b2 =  TestDataUtil.b2;
		BlacklistContent b3 =  TestDataUtil.b3;
		
		blacklistContentService.create(b1.getId(), b1.getWord(), b1.getLang());
		blacklistContentService.create(b2.getId(), b2.getWord(), b2.getLang());
		blacklistContentService.create(b3.getId(), b3.getWord(), b3.getLang());
		List<BlacklistContent> findAllResult =
				blacklistContentService.getAllBlackListContentByLang("en");
		
		ReviewResult rr = TestDataUtil.getTestUserContentReviewResult("1");//sample result for txt
		
		ReviewResult ur = userContentReviewService.reviewContent("1", txt, "en");
		
		System.out.println("------------------"+ur.toString());
		
		List<String> rrwords = rr.getBlacklistedWords();
		List<String> urwords = ur.getBlacklistedWords();
		System.out.println("------------------");
		System.out.println(rr.toString());
		System.out.println(ur.toString());
		System.out.println("------------------");
		boolean res = true; 
		
		if(rrwords.size() == urwords.size()) { 
			for (int i=0;i<rrwords.size();i++) { 
				if(!rrwords.get(i).equals(urwords.get(i))) 
				{
					res=false; 
					break; 
				} 
			} 
		}else {
			res=false; 
		} 
		//Assert.assertTrue(res); 
		
		}

}
