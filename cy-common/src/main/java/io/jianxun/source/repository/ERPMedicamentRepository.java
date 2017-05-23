package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.source.domain.QERPMedicament;

public interface ERPMedicamentRepository extends JpaRepository<ERPMedicament, String>,
		QueryDslPredicateExecutor<ERPMedicament>, QuerydslBinderCustomizer<QERPMedicament> {
	@Override
	default void customize(QuerydslBindings bindings, QERPMedicament root) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}
}
