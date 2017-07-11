package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPHwspKey is a Querydsl query type for ERPHwspKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QERPHwspKey extends BeanPath<ERPHwspKey> {

    private static final long serialVersionUID = -253969832L;

    public static final QERPHwspKey eRPHwspKey = new QERPHwspKey("eRPHwspKey");

    public final StringPath hw = createString("hw");

    public final StringPath spid = createString("spid");

    public QERPHwspKey(String variable) {
        super(ERPHwspKey.class, forVariable(variable));
    }

    public QERPHwspKey(Path<? extends ERPHwspKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPHwspKey(PathMetadata metadata) {
        super(ERPHwspKey.class, metadata);
    }

}

