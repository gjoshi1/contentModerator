/**
 * 
 */
package com.target.contentModerator.service;

import static org.junit.Assert.fail;

import java.util.Collections;
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
import com.target.contentModerator.repository.BlacklistContentRepository;
import com.target.contentModerator.utils.TestDataUtil;

/**
 * @author Gowri Joshi
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ContentModeratorApiApplication.class)
public class BlacklistContentServiceTest {

	@InjectMocks private BlacklistContentService blacklistContentService;
	@Mock private BlacklistContentRepository blacklistContentRepository;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.target.contentModerator.service.BlacklistContentService#create(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreate() {
		BlacklistContent b1 = TestDataUtil.b1;
		Mockito.when(blacklistContentRepository.save(Mockito.any(BlacklistContent.class))).thenReturn(b1);
		
		BlacklistContent bc = blacklistContentService.create(b1.getId(),b1.getWord(), b1.getLang());
		
		System.out.println("TESSSSSSTINGGGGG");
		System.out.println(bc.getId()+"---------"+b1.getId());
		Assert.assertEquals(bc.getId(),b1.getId());
	}

	

	/**
	 * Test method for {@link com.target.contentModerator.service.BlacklistContentService#deleteAll()}.
	 */
	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.target.contentModerator.service.BlacklistContentService#delete(java.lang.String)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.target.contentModerator.service.BlacklistContentService#getAllBlackListContent()}.
	 */
	
	  @Test public void testGetAllBlackListContent() { List<BlacklistContent>
	  bcList = TestDataUtil.getTestDataList();
	  Mockito.when(blacklistContentRepository.findAll()).thenReturn(bcList);
	  
	  List<BlacklistContent> findAllResult =
	  blacklistContentService.getAllBlackListContent();
	  
	  boolean res = true; if(bcList.size() == findAllResult.size()) { for (int i=0
	  ;i<bcList.size();i++) { if(!bcList.get(i).equals(findAllResult.get(i))) {
	  res=false; break; } } }else { res=false; } Assert.assertTrue(res); }
	 
	/**
	 * Test method for {@link com.target.contentModerator.service.BlacklistContentService#getAllBlackListContentByLang(java.lang.String)}.
	 */
	@Test
	public void testGetAllBlackListContentByLang() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.target.contentModerator.service.BlacklistContentService#getSupportedLanguages()}.
	 */
	@Test
	public void testGetSupportedLanguages() {
		fail("Not yet implemented");
	}

}
