package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPSphwphKey is a Querydsl query type for ERPSphwphKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QERPSphwphKey extends BeanPath<ERPSphwphKey> {

    private static final long serialVersionUID = 2088211104L;

    public static final QERPSphwphKey eRPSphwphKey = new QERPSphwphKey("eRPSphwphKey");

    public final StringPath hw = createString("hw");

    public final StringPath pihao = createString("pihao");

    public final StringPath spid = createString("spid");

    public QERPSphwphKey(String variable) {
        super(ERPSphwphKey.class, forVariable(variable));
    }

    public QERPSphwphKey(Path<? extends ERPSphwphKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPSphwphKey(PathMetadata metadata) {
        super(ERPSphwphKey.class, metadata);
    }

}

