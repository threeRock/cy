package io.jianxun.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

import io.jianxun.source.domain.ERPFenLei;
import io.jianxun.source.domain.QERPFenLei;

public interface ERPFenLeiRepository extends JpaRepository<ERPFenLei, String>,
		QueryDslPredicateExecutor<ERPFenLei>, QuerydslBinderCustomizer<QERPFenLei> {

	@Override
	default void customize(QuerydslBindings bindings, QERPFenLei root) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
