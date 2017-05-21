package io.jianxun.source.repository;

import io.jianxun.source.domain.ERPHuoweizl;
import io.jianxun.source.domain.ERPMedicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ERPHuoweizlRepository
		extends JpaRepository< ERPHuoweizl, String>, QueryDslPredicateExecutor<ERPHuoweizl> {

}

