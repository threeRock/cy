package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import io.jianxun.source.domain.ERPMedicamentBatch;
import io.jianxun.source.domain.ERPMedicamentBatchKey;

public interface ERPMedicamentBatchRepository
		extends JpaRepository<ERPMedicamentBatch, ERPMedicamentBatchKey>, QueryDslPredicateExecutor<ERPMedicamentBatch> {

}
