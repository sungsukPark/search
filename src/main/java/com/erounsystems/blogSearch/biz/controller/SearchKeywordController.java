package com.erounsystems.blogSearch.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
import com.erounsystems.blogSearch.biz.service.SearchKeywordService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("popular")
@Slf4j
public class SearchKeywordController {
	
	@Autowired
	private SearchKeywordService searchKeywordService;
	


	  /*
	   * 인기 검색어 목록
	   */
	  @GetMapping("/popSearchKeywordList")
	  public ResponseEntity<List<TpSearchKeyword>> popSearchKeywordList() {
		Pageable paging =  PageRequest.of(0,10,Sort.Direction.DESC,"searchCnt");  
		List<TpSearchKeyword> popSearchKeywordList  = searchKeywordService.getPopSearchKeywordList(paging).getContent();
				  
	    if(popSearchKeywordList.size() >0 ){
	    	//ResponseDto responseDto = new ResponseDto(200, "내가 저장한 전시회에 추가되었습니다.");
	      return new ResponseEntity<List<TpSearchKeyword>>(popSearchKeywordList, HttpStatus.OK);
	    }
	    else{
	      return new ResponseEntity<List<TpSearchKeyword>>(HttpStatus.NOT_FOUND);
	    }
	  }

}
