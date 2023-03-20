package com.erounsystems.blogSearch.biz.service;

import static com.erounsystems.blogSearch.common.enums.ErrorCode.INVALID_PARAMETER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
import com.erounsystems.blogSearch.biz.repository.TpSearchKeywordRepository;
import com.erounsystems.blogSearch.exception.CustomException;
@Service
@Transactional
public class SearchKeywordService {
	
	@Autowired	
	private TpSearchKeywordRepository searchKeywordRepository;
	
	public Page<TpSearchKeyword> getPopSearchKeywordList(Pageable paging) {
		return searchKeywordRepository.findAll(paging);
		
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
		/*
		 * List<TpSearchKeyword> temp= searchKeywordRepository.findAll(); if(true)
		 */
			//throw new ParameterException("hashtag name cannot be null or empty");

		//			throw new CustomException(INVALID_PARAMETER);
		
				
	}

}
