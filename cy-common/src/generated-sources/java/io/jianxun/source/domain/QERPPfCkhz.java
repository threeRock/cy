package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QERPPfCkhz is a Querydsl query type for ERPPfCkhz
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPPfCkhz extends EntityPathBase<ERPPfCkhz> {

    private static final long serialVersionUID = 342254251L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QERPPfCkhz eRPPfCkhz = new QERPPfCkhz("eRPPfCkhz");

    public final StringPath dwbh = createString("dwbh");

    public final QERPPfCkhzKey id;

    public final StringPath rq = createString("rq");

    public final StringPath spid = createString("spid");

    public QERPPfCkhz(String variable) {
        this(ERPPfCkhz.class, forVariable(variable), INITS);
    }

    public QERPPfCkhz(Path<? extends ERPPfCkhz> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QERPPfCkhz(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QERPPfCkhz(PathMetadata metadata, PathInits inits) {
        this(ERPPfCkhz.class, metadata, inits);
    }

    public QERPPfCkhz(Class<? extends ERPPfCkhz> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QERPPfCkhzKey(forProperty("id")) : null;
    }

}

