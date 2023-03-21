package com.erounsystems.blogSearch.biz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TpSearchKeyword {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
	private String keyword;
	
	private Integer searchCnt;	
	
	public TpSearchKeyword(String keyword, Integer searchCnt){
		this.keyword = keyword;
		this.searchCnt = searchCnt;
	}

	
}
