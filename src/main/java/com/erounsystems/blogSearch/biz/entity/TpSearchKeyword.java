package com.erounsystems.blogSearch.biz.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table
@Data
public class TpSearchKeyword {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
	private String keyword;
	
	private Integer searchCnt;	
	
	/*
	@CreationTimestamp
	private Instant createDate;
	@UpdateTimestamp
	private Instant updateDate;
	*/

}
