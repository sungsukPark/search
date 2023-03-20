package com.erounsystems.blogSearch.biz.service;




import static com.erounsystems.blogSearch.common.enums.ErrorCode.INVALID_PARAMETER;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.erounsystems.blogSearch.biz.dto.KakaoBlogReqDto;
import com.erounsystems.blogSearch.biz.dto.KakaoBlogResDto;
import com.erounsystems.blogSearch.biz.entity.Response;
import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
import com.erounsystems.blogSearch.biz.repository.TpSearchKeywordRepository;
import com.erounsystems.blogSearch.exception.CustomException;

import lombok.RequiredArgsConstructor;;

@RequiredArgsConstructor
@Service
@Transactional
public class BlogSearchService {

    private ApiService<Response> apiService;

    @Value("${kakao.openapi.blog.url}")
    private String url;
    @Value("${kakao.openapi.authorization}")
    private String key;

    @Autowired
    private TpSearchKeywordRepository searchKeywordRepository;
   
	public KakaoBlogResDto getBlog(KakaoBlogReqDto param) {
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + key); //Authorization 설정
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders); //엔티티로 만들기
        URI targetUrl = UriComponentsBuilder
                .fromUriString(url) 
                .queryParam("query", param)
                .build()
                .encode(StandardCharsets.UTF_8) //인코딩
                .toUri();

        //GetForObject는 헤더를 정의할 수 없음
        ResponseEntity<KakaoBlogResDto> result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, KakaoBlogResDto.class);
//        restTemplate.setErrorHandler(new MyErrorHandler());
        
        return result.getBody(); //내용 반환
	}



	public void saveKeyword(String query) {
		// TODO Auto-generated method stub
		TpSearchKeyword searchKeyword = searchKeywordRepository.findByKeyword(query);
		
		if(searchKeyword != null) {
			searchKeyword.setSearchCnt(searchKeyword.getSearchCnt() +1 );
			searchKeywordRepository.save(searchKeyword);
		}else {
			searchKeyword = new TpSearchKeyword();
			searchKeyword.setKeyword(query);
			searchKeyword.setSearchCnt(1);
			searchKeywordRepository.save(searchKeyword);
		}
		List<TpSearchKeyword>  temp= searchKeywordRepository.findAll();
		if(true)
			//throw new ParameterException("hashtag name cannot be null or empty");

					throw new CustomException(INVALID_PARAMETER);
		
				
	}
}