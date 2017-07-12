package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import io.jianxun.source.domain.ERPSpQuyu;

public interface ERPSpQuyuRepository
		extends JpaRepository<ERPSpQuyu, String>, QueryDslPredicateExecutor<ERPSpQuyu> {


}
