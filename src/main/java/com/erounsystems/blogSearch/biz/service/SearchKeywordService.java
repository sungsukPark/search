package com.erounsystems.blogSearch.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
import com.erounsystems.blogSearch.biz.repository.TpSearchKeywordRepository;
@Service
@Transactional
public class SearchKeywordService {
	
	@Autowired	
	private TpSearchKeywordRepository searchKeywordRepository;
	
	public Page<TpSearchKeyword> getPopSearchKeywordList(Pageable paging) {
		return searchKeywordRepository.findAll(paging);
		
	}

}
