package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

import io.jianxun.source.domain.ERPPfCkhz;
import io.jianxun.source.domain.QERPPfCkhz;

public interface ERPPfCkhzRepository extends JpaRepository<ERPPfCkhz, String>,
		QueryDslPredicateExecutor<ERPPfCkhz>, QuerydslBinderCustomizer<QERPPfCkhz> {
	@Override
	default void customize(QuerydslBindings bindings, QERPPfCkhz root) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}
}
