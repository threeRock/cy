package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPFenLei is a Querydsl query type for ERPFenLei
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPFenLei extends EntityPathBase<ERPFenLei> {

    private static final long serialVersionUID = 56290332L;

    public static final QERPFenLei eRPFenLei = new QERPFenLei("eRPFenLei");

    public final StringPath tfatherid = createString("tfatherid");

    public final StringPath tid = createString("tid");

    public final StringPath tname = createString("tname");

    public QERPFenLei(String variable) {
        super(ERPFenLei.class, forVariable(variable));
    }

    public QERPFenLei(Path<? extends ERPFenLei> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPFenLei(PathMetadata metadata) {
        super(ERPFenLei.class, metadata);
    }

}

