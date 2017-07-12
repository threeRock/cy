package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPSpQuyuKey is a Querydsl query type for ERPSpQuyuKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QERPSpQuyuKey extends BeanPath<ERPSpQuyuKey> {

    private static final long serialVersionUID = -1193063705L;

    public static final QERPSpQuyuKey eRPSpQuyuKey = new QERPSpQuyuKey("eRPSpQuyuKey");

    public final StringPath khquyu = createString("khquyu");

    public final StringPath spid = createString("spid");

    public QERPSpQuyuKey(String variable) {
        super(ERPSpQuyuKey.class, forVariable(variable));
    }

    public QERPSpQuyuKey(Path<? extends ERPSpQuyuKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPSpQuyuKey(PathMetadata metadata) {
        super(ERPSpQuyuKey.class, metadata);
    }

}

