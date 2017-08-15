package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

import io.jianxun.source.domain.ERPIpadkc;
import io.jianxun.source.domain.QERPIpadkc;

public interface ERPIpadkcRepository extends JpaRepository<ERPIpadkc, String>,
		QueryDslPredicateExecutor<ERPIpadkc>, QuerydslBinderCustomizer<QERPIpadkc> {

	@Override
	default void customize(QuerydslBindings bindings, QERPIpadkc root) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
