package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPPfCkhzKey is a Querydsl query type for ERPPfCkhzKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QERPPfCkhzKey extends BeanPath<ERPPfCkhzKey> {

    private static final long serialVersionUID = -155893836L;

    public static final QERPPfCkhzKey eRPPfCkhzKey = new QERPPfCkhzKey("eRPPfCkhzKey");

    public final StringPath djbh = createString("djbh");

    public final StringPath djSn = createString("djSn");

    public QERPPfCkhzKey(String variable) {
        super(ERPPfCkhzKey.class, forVariable(variable));
    }

    public QERPPfCkhzKey(Path<? extends ERPPfCkhzKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPPfCkhzKey(PathMetadata metadata) {
        super(ERPPfCkhzKey.class, metadata);
    }

}

