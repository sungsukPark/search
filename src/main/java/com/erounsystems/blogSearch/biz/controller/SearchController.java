package com.erounsystems.blogSearch.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erounsystems.blogSearch.biz.dto.KakaoBlogReqDto;
import com.erounsystems.blogSearch.biz.dto.KakaoBlogResDto;
import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
import com.erounsystems.blogSearch.biz.service.BlogSearchService;
import com.erounsystems.blogSearch.biz.service.SearchKeywordService;

@RestController
public class SearchController {
	
	@Autowired
    private BlogSearchService blogSearchService;

    @Autowired
	private SearchKeywordService searchKeywordService;
    
	/*
	 * 블로그 검색
	 */   
    @GetMapping("/blogSearch")
    public ResponseEntity<KakaoBlogResDto> blogSearch(KakaoBlogReqDto param){       
        
        // 검색어 저장
    	searchKeywordService.saveKeyword(param.getQuery());  
    	// 블로그 검색
    	KakaoBlogResDto kakaoBlogResDto = blogSearchService.getBlog(param);
        return new ResponseEntity<KakaoBlogResDto>(kakaoBlogResDto, HttpStatus.OK);
    }
    

    /*
     * 인기 검색어 목록
     */
    @GetMapping("/popualKeywordList")
    public ResponseEntity<List<TpSearchKeyword>> popSearchKeywordList() {
    	Pageable paging =  PageRequest.of(0,10,Sort.Direction.DESC,"searchCnt");  
		List<TpSearchKeyword> popSearchKeywordList  = searchKeywordService.getPopSearchKeywordList(paging).getContent();
			
		return new ResponseEntity<List<TpSearchKeyword>>(popSearchKeywordList, HttpStatus.OK);
    }
    
}