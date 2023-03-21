package com.erounsystems.blogSearch.biz.service;




import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.erounsystems.blogSearch.biz.dto.KakaoBlogReqDto;
import com.erounsystems.blogSearch.biz.dto.KakaoBlogResDto;
import com.erounsystems.blogSearch.biz.repository.TpSearchKeywordRepository;

import lombok.RequiredArgsConstructor;;

@RequiredArgsConstructor
@Service
@Transactional
public class BlogSearchService {


    @Value("${kakao.openapi.blog.url}")
    private String url;
    @Value("${kakao.openapi.authorization}")
    private String key;

    @Autowired
    private TpSearchKeywordRepository searchKeywordRepository;
   
	public KakaoBlogResDto getBlog(KakaoBlogReqDto param) {
		
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();        
        //Authorization 설정
        httpHeaders.set("Authorization", "KakaoAK " + key);
        //httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders); 
        
        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
        
        URI targetUrl = UriComponentsBuilder
                .fromUriString(url) 
                .queryParam("query", param.getQuery())
                .build()
                .encode(StandardCharsets.UTF_8) 
                .toUri();

        //GetForObject는 헤더를 정의할 수 없음
        KakaoBlogResDto result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<KakaoBlogResDto>(){}).getBody();
//        restTemplate.setErrorHandler(new MyErrorHandler());
        
        return result; //내용 반환
	}



}