package com.erounsystems.blogSearch.biz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erounsystems.blogSearch.biz.entity.TpSearchKeyword;
@Repository
public interface TpSearchKeywordRepository extends JpaRepository<TpSearchKeyword,Long>{
	
	//List<TpSearchKeyword> findOrderBySearchCntDesc(Pageable paging);

	TpSearchKeyword findByKeyword(String keyword);

}
