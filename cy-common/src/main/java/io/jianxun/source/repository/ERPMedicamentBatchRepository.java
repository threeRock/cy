package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

import io.jianxun.source.domain.ERPMedicamentBatch;
import io.jianxun.source.domain.ERPMedicamentBatchKey;
import io.jianxun.source.domain.QERPMedicamentBatch;

public interface ERPMedicamentBatchRepository extends JpaRepository<ERPMedicamentBatch, ERPMedicamentBatchKey>,
		QueryDslPredicateExecutor<ERPMedicamentBatch>, QuerydslBinderCustomizer<QERPMedicamentBatch> {

	@Override
	default void customize(QuerydslBindings bindings, QERPMedicamentBatch root) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}
}
