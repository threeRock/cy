package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import io.jianxun.source.domain.ERPHuoweizl;

public interface ERPHuoweizlRepository
		extends JpaRepository< ERPHuoweizl, String>, QueryDslPredicateExecutor<ERPHuoweizl> {

}
