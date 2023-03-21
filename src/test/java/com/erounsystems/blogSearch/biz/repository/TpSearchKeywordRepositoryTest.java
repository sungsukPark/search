package com.erounsystems.blogSearch.biz.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.erounsystems.blogSearch.biz.dto.SearchKeywordReqDto;
import com.erounsystems.blogSearch.biz.dto.SearchKeywordResDto;
import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;

@DataJpaTest
class TpSearchKeywordRepositoryTest {

	@Autowired	
	private TpSearchKeywordRepository searchKeywordRepository;
	
 
	
	@Test
	@DisplayName("keywork로 조회 테스트")
	void testFindByKeyword() {
		        
      	// given
		TpSearchKeyword saveKeyword1 = searchKeywordRepository.save(new SearchKeywordReqDto("집짓기",3).toEntity());
		TpSearchKeyword saveKeyword2 = searchKeywordRepository.save(new SearchKeywordReqDto("축구",5).toEntity());
		
		// when
		TpSearchKeyword findKeyword1 = searchKeywordRepository.findByKeyword(saveKeyword1.getKeyword());
		TpSearchKeyword findKeyword2 = searchKeywordRepository.findByKeyword(saveKeyword2.getKeyword());
		
		// then
		Assertions.assertThat(searchKeywordRepository.count()).isEqualTo(2);
		Assertions.assertThat(findKeyword1.getKeyword()).isEqualTo("집짓기");
		Assertions.assertThat(findKeyword1.getSearchCnt()).isEqualTo(3);
		Assertions.assertThat(findKeyword2.getKeyword()).isEqualTo("축구");
		Assertions.assertThat(findKeyword2.getSearchCnt()).isEqualTo(5);
		
	}
	
	@Test
	@DisplayName("keywork 저장 테스트")
	void testSave() {
		// given
		String keyword = "부동산";
		SearchKeywordReqDto searchKeyword = new SearchKeywordReqDto(keyword,4);
		// when
		 TpSearchKeyword saveKeyword = searchKeywordRepository.save(searchKeyword.toEntity());

		// then
		assertEquals(keyword, saveKeyword.getKeyword());
	}

}
