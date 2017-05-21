package io.jianxun.source.repository;

import io.jianxun.source.domain.ERPHuoweizl;
import io.jianxun.source.domain.ERPMchk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ERPMchkRepository
		extends JpaRepository<ERPMchk, String>, QueryDslPredicateExecutor<ERPMchk> {

}

