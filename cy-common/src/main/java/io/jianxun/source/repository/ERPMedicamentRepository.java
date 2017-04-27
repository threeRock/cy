package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import io.jianxun.source.domain.ERPMedicament;

public interface ERPMedicamentRepository
		extends JpaRepository<ERPMedicament, String>, QueryDslPredicateExecutor<ERPMedicament> {

}
