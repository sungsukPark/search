package com.erounsystems.blogSearch.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erounsystems.blogSearch.biz.dto.KakaoBlogReqDto;
import com.erounsystems.blogSearch.biz.dto.KakaoBlogResDto;
import com.erounsystems.blogSearch.biz.service.BlogSearchService;

@RestController
public class KakaoSearchController {

    private BlogSearchService blogSearchService;

    @Autowired
    public KakaoSearchController(BlogSearchService blogSearchService) {
        this.blogSearchService =blogSearchService;
    }


    

    @GetMapping("/blogSearch")
    public ResponseEntity<KakaoBlogResDto> callApi(KakaoBlogReqDto param){       
        
        // 검색어 저장
    	blogSearchService.saveKeyword(param.getQuery());        
        return ResponseEntity.ok(blogSearchService.getBlog(param));
    }
    /*
    
    @RequestMapping("/rest/test1")
    public ResponseEntity<?> restTemplateTest1() {
        return ResponseEntity.ok(blogSearchService.callPostExternalServer());
    }
    
    @GetMapping("/v2/search/blog")
    public ResponseEntity<?> getBlog(){
    	return ResponseEntity.ok(blogSearchService.getBlog());
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    */
}