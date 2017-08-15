package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPIpadkcKey is a Querydsl query type for ERPIpadkcKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QERPIpadkcKey extends BeanPath<ERPIpadkcKey> {

    private static final long serialVersionUID = 516607650L;

    public static final QERPIpadkcKey eRPIpadkcKey = new QERPIpadkcKey("eRPIpadkcKey");

    public final StringPath spid = createString("spid");

    public QERPIpadkcKey(String variable) {
        super(ERPIpadkcKey.class, forVariable(variable));
    }

    public QERPIpadkcKey(Path<? extends ERPIpadkcKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPIpadkcKey(PathMetadata metadata) {
        super(ERPIpadkcKey.class, metadata);
    }

}

