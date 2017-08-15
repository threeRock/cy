package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QERPIpadkc is a Querydsl query type for ERPIpadkc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPIpadkc extends EntityPathBase<ERPIpadkc> {

    private static final long serialVersionUID = 151972477L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QERPIpadkc eRPIpadkc = new QERPIpadkc("eRPIpadkc");

    public final QERPIpadkcKey id;

    public final NumberPath<java.math.BigDecimal> shl = createNumber("shl", java.math.BigDecimal.class);

    public QERPIpadkc(String variable) {
        this(ERPIpadkc.class, forVariable(variable), INITS);
    }

    public QERPIpadkc(Path<? extends ERPIpadkc> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QERPIpadkc(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QERPIpadkc(PathMetadata metadata, PathInits inits) {
        this(ERPIpadkc.class, metadata, inits);
    }

    public QERPIpadkc(Class<? extends ERPIpadkc> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QERPIpadkcKey(forProperty("id")) : null;
    }

}

