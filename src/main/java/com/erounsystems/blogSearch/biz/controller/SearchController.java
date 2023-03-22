package com.erounsystems.blogSearch.biz.controller;

import static com.erounsystems.blogSearch.common.enums.ErrorCode.VALIDATION_SORT_ERROR;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erounsystems.blogSearch.biz.dto.BlogSerchDto;
import com.erounsystems.blogSearch.biz.dto.KakaoBlogReqDto;
import com.erounsystems.blogSearch.biz.dto.KakaoBlogResDto;
import com.erounsystems.blogSearch.biz.dto.SearchKeywordResDto;
import com.erounsystems.blogSearch.biz.service.BlogSearchService;
import com.erounsystems.blogSearch.biz.service.SearchKeywordService;
import com.erounsystems.blogSearch.exception.CustomException;

import jakarta.validation.Valid;

@RestController
public class SearchController {
	
	@Autowired
    private BlogSearchService blogSearchService;

    @Autowired
	private SearchKeywordService searchKeywordService;
    
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	/*
	 * 블로그 검색
	 */   
    @GetMapping("/v1/blogSearch")
    public ResponseEntity<KakaoBlogResDto> blogSearch( @Valid KakaoBlogReqDto param){       

           
        // 검색어 저장
    	searchKeywordService.saveKeyword(param.getQuery());  
    	// 블로그 검색
    	KakaoBlogResDto kakaoBlogResDto = blogSearchService.getBlog(param);
    	
    	
        return new ResponseEntity<KakaoBlogResDto>(kakaoBlogResDto, HttpStatus.OK);
    }
    

    /*
     * 인기 검색어 목록
     */
    @GetMapping("/v1/popualKeyword")
    public ResponseEntity<List<SearchKeywordResDto>> popSearchKeywordList() {
    	
    	Pageable paging =  PageRequest.of(0,10,Sort.Direction.DESC,"searchCnt");  
		List<SearchKeywordResDto> popSearchKeywordList  = searchKeywordService.getPopSearchKeywordList(paging);
			
		return new ResponseEntity<List<SearchKeywordResDto>>(popSearchKeywordList, HttpStatus.OK);
		
    }
    
}