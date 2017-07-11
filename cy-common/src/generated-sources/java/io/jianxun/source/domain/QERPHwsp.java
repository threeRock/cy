package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QERPHwsp is a Querydsl query type for ERPHwsp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPHwsp extends EntityPathBase<ERPHwsp> {

    private static final long serialVersionUID = 1358793351L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QERPHwsp eRPHwsp = new QERPHwsp("eRPHwsp");

    public final NumberPath<java.math.BigDecimal> hwshl = createNumber("hwshl", java.math.BigDecimal.class);

    public final QERPHwspKey id;

    public QERPHwsp(String variable) {
        this(ERPHwsp.class, forVariable(variable), INITS);
    }

    public QERPHwsp(Path<? extends ERPHwsp> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QERPHwsp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QERPHwsp(PathMetadata metadata, PathInits inits) {
        this(ERPHwsp.class, metadata, inits);
    }

    public QERPHwsp(Class<? extends ERPHwsp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QERPHwspKey(forProperty("id")) : null;
    }

}

