package com.ottt.ottt;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ottt.ottt.dao.community.communityDao;
import com.ottt.ottt.dto.ArticleDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class communityTest {

	@Autowired
	private communityDao communityDao;
	
	
	@Test
	public void insertDummyTestData() throws Exception{
		
		for (int i=1; i<=50; i++) {
			ArticleDTO articleDTO = new ArticleDTO("가나다"+i , 123);
			communityDao.insert(articleDTO);
		}
	}
	
	//@Test
	public void selectcollectionTest() throws Exception{
		List<ArticleDTO> list = communityDao.selectcollection(1);
		assertTrue(list.size()==5);
		
	}
	
}
