package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import io.jianxun.source.domain.ERPHwsp;
import io.jianxun.source.domain.ERPHwspKey;

public interface ERPHwspRepository extends JpaRepository<ERPHwsp, ERPHwspKey>, QueryDslPredicateExecutor<ERPHwsp> {
}
