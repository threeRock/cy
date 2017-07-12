package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import io.jianxun.source.domain.ERPHwspKey;
import io.jianxun.source.domain.ERPSphwph;

public interface ERPSphwphRepository
		extends JpaRepository<ERPSphwph, ERPHwspKey>, QueryDslPredicateExecutor<ERPSphwph> {
}
