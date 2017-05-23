package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

import io.jianxun.source.domain.ERPHuoweizl;
import io.jianxun.source.domain.QERPHuoweizl;

public interface ERPHuoweizlRepository extends JpaRepository<ERPHuoweizl, String>,
		QueryDslPredicateExecutor<ERPHuoweizl>, QuerydslBinderCustomizer<QERPHuoweizl> {

	@Override
	default void customize(QuerydslBindings bindings, QERPHuoweizl root) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
