package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import io.jianxun.source.domain.ERPMchk;

public interface ERPMchkRepository
		extends JpaRepository<ERPMchk, String>, QueryDslPredicateExecutor<ERPMchk> {

}

