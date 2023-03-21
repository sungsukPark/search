package com.erounsystems.blogSearch.biz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
import com.erounsystems.blogSearch.biz.repository.TpSearchKeywordRepository;


@ExtendWith(MockitoExtension.class)
@DisplayName("Search Keyword Service 테스트")
class SearchKeywordServiceTest {

	@Mock 
	private TpSearchKeywordRepository searchKeywordRepository;

	@Autowired
	private SearchKeywordService searchKeywordService;
	  
   
	  
	@Test
	@Disabled
	void testGetPopSearchKeywordList() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("save() 테스트")
	void testSaveKeyword() {
		//given
		String query = "부동산";
		
		String keyword = "집짓기";
		TpSearchKeyword searchKeyword = TpSearchKeyword.builder()
											.keyword(keyword)
											.searchCnt(3).build();		
		//when
		final TpSearchKeyword saveKeyword = searchKeywordService.saveKeyword(query);
		
		//then
		assertEquals(query, saveKeyword.getKeyword());
	}

}