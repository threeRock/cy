package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QERPSphwph is a Querydsl query type for ERPSphwph
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPSphwph extends EntityPathBase<ERPSphwph> {

    private static final long serialVersionUID = 438490943L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QERPSphwph eRPSphwph = new QERPSphwph("eRPSphwph");

    public final QERPSphwphKey id;

    public final StringPath pihao2 = createString("pihao2");

    public final NumberPath<java.math.BigDecimal> shl = createNumber("shl", java.math.BigDecimal.class);

    public final StringPath sxrq = createString("sxrq");

    public QERPSphwph(String variable) {
        this(ERPSphwph.class, forVariable(variable), INITS);
    }

    public QERPSphwph(Path<? extends ERPSphwph> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QERPSphwph(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QERPSphwph(PathMetadata metadata, PathInits inits) {
        this(ERPSphwph.class, metadata, inits);
    }

    public QERPSphwph(Class<? extends ERPSphwph> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QERPSphwphKey(forProperty("id")) : null;
    }

}

