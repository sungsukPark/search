package com.erounsystems.blogSearch.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erounsystems.blogSearch.biz.dto.SearchKeywordReqDto;
import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
import com.erounsystems.blogSearch.biz.repository.TpSearchKeywordRepository;
import com.erounsystems.blogSearch.exception.CustomException;
import static com.erounsystems.blogSearch.common.enums.ErrorCode.ENTITY_DUPLICATION;
@Service
@Transactional
public class SearchKeywordService {
	
	@Autowired	
	private TpSearchKeywordRepository searchKeywordRepository;
	
	public Page<TpSearchKeyword> getPopSearchKeywordList(Pageable paging) {
		return searchKeywordRepository.findAll(paging);
		
	}
	

	public TpSearchKeyword saveKeyword(String query) {
		TpSearchKeyword searchKeyword = searchKeywordRepository.findByKeyword(query);
		TpSearchKeyword saveKeyword = null;
		
		if(searchKeyword != null) {
			searchKeyword.setSearchCnt(searchKeyword.getSearchCnt() +1 );
			saveKeyword= searchKeywordRepository.save(searchKeyword);
		}else {
			SearchKeywordReqDto searchKeywordReq = new SearchKeywordReqDto(query,1);
			saveKeyword =searchKeywordRepository.save(searchKeywordReq.toEntity());
		}
		
		if(saveKeyword == null) {
			throw new CustomException(ENTITY_DUPLICATION);
		}	
		
		return saveKeyword;
		
	}

}
