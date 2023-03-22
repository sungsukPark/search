package com.erounsystems.blogSearch.biz.service;




import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.erounsystems.blogSearch.biz.dto.KakaoBlogReqDto;
import com.erounsystems.blogSearch.biz.dto.KakaoBlogResDto;

import lombok.RequiredArgsConstructor;;

@RequiredArgsConstructor
@Service
@Transactional
public class BlogSearchService {


    @Value("${kakao.openapi.blog.url}")
    private String url;
    @Value("${kakao.openapi.authorization}")
    private String key;

  
   
	public KakaoBlogResDto getBlog(KakaoBlogReqDto param) {
		
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();       
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //Authorization 설정
        httpHeaders.set("Authorization", "KakaoAK " + key);
        
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders); 
        
       
        
        URI targetUrl = UriComponentsBuilder
                .fromUriString(url) 
                .queryParam("query", param.getQuery())
                .queryParam("sort", param.getSort())
                .queryParam("page",param.getPage())
                .queryParam("size",param.getSize())                
                .build()
                .encode(StandardCharsets.UTF_8) 
                .toUri();
        
        ResponseEntity<KakaoBlogResDto> result = null;

    	result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, KakaoBlogResDto.class);
 
        return result.getBody();
	}



}