package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPHuoweizl is a Querydsl query type for ERPHuoweizl
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPHuoweizl extends EntityPathBase<ERPHuoweizl> {

    private static final long serialVersionUID = -1165410970L;

    public static final QERPHuoweizl eRPHuoweizl = new QERPHuoweizl("eRPHuoweizl");

    public final StringPath huowname = createString("huowname");

    public final StringPath hw = createString("hw");

    public final StringPath hwbh = createString("hwbh");

    public QERPHuoweizl(String variable) {
        super(ERPHuoweizl.class, forVariable(variable));
    }

    public QERPHuoweizl(Path<? extends ERPHuoweizl> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPHuoweizl(PathMetadata metadata) {
        super(ERPHuoweizl.class, metadata);
    }

}

