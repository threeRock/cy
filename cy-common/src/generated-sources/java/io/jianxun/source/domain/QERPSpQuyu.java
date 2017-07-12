package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QERPSpQuyu is a Querydsl query type for ERPSpQuyu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPSpQuyu extends EntityPathBase<ERPSpQuyu> {

    private static final long serialVersionUID = 437804120L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QERPSpQuyu eRPSpQuyu = new QERPSpQuyu("eRPSpQuyu");

    public final StringPath beactive = createString("beactive");

    public final QERPSpQuyuKey id;

    public final NumberPath<java.math.BigDecimal> zbjg = createNumber("zbjg", java.math.BigDecimal.class);

    public QERPSpQuyu(String variable) {
        this(ERPSpQuyu.class, forVariable(variable), INITS);
    }

    public QERPSpQuyu(Path<? extends ERPSpQuyu> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QERPSpQuyu(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QERPSpQuyu(PathMetadata metadata, PathInits inits) {
        this(ERPSpQuyu.class, metadata, inits);
    }

    public QERPSpQuyu(Class<? extends ERPSpQuyu> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QERPSpQuyuKey(forProperty("id")) : null;
    }

}

