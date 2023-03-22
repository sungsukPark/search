package com.erounsystems.blogSearch.biz.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import com.erounsystems.blogSearch.biz.dto.KakaoBlogResDto;
import com.erounsystems.blogSearch.biz.dto.SearchKeywordReqDto;
import com.erounsystems.blogSearch.biz.service.BlogSearchService;
import com.erounsystems.blogSearch.biz.service.SearchKeywordService;
import com.erounsystems.blogSearch.biz.vo.KakaoBlogDocuments;
import com.erounsystems.blogSearch.biz.vo.KakaoBlogMeta;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
@WebMvcTest(SearchController.class)
@DisplayName("SearchController 테스트")
class SearchControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SearchKeywordService searchKeywordService;
	
	@MockBean
	private BlogSearchService blogSearchService;
	
	@Test
	@DisplayName("블로그 검색 테스트1")
	void test1BlogSearch() throws Exception {
		//given
		List<KakaoBlogDocuments> documents = new ArrayList<KakaoBlogDocuments>();
     
		//documents.add(KakaoBlogDocuments.builder().title("title").contents("content").url("abc").blogname("blogname").thumbnail("thumbnail").build());
		KakaoBlogResDto kakaoBlogResDto = KakaoBlogResDto.builder().meta(KakaoBlogMeta.builder().total_count(100).pageable_count(50).is_end(false).build())
								 .documents(documents).build();
		
		//when
		when(searchKeywordService.saveKeyword(any())).thenReturn(new SearchKeywordReqDto("집짓기",3).toEntity());
		when(blogSearchService.getBlog(any())).thenReturn( kakaoBlogResDto);

		//
		mockMvc.perform(get("/v1/blogSearch").param("query","부동산"))
		        .andDo(print())               
		        .andExpect(status().isOk());

	}
	
	@Test
	@DisplayName("블로그 검색 테스트2")
	void test2BlogSearch() throws Exception {
	
		mockMvc.perform(get("/v1/blogSearch")
						.param("query","부동산")
						.param("sort","recency"))
		        .andDo(print())               
		        .andExpect(status().isOk());

	}
	
	@Test
	@DisplayName("블로그 검색 테스트3")
	void test3BlogSearch() throws Exception {
	
		mockMvc.perform(get("/v1/blogSearch")
						.param("query","부동산")
						.param("sort","recency")
						.param("page","1")
						.param("size","5"))
		        .andDo(print())               
		        .andExpect(status().isOk());

	}

	@Test
	@DisplayName("인기 검색어 목록 테스트")
	void testPopSearchKeywordList() throws Exception {
		
		mockMvc.perform(get("/v1/popualKeyword"))
        .andDo(print())               
        .andExpect(status().isOk());
	}

}
