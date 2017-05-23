package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

import io.jianxun.source.domain.ERPMchk;
import io.jianxun.source.domain.QERPMchk;

public interface ERPMchkRepository
		extends JpaRepository<ERPMchk, String>, QueryDslPredicateExecutor<ERPMchk>, QuerydslBinderCustomizer<QERPMchk> {

	@Override
	default void customize(QuerydslBindings bindings, QERPMchk root) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
