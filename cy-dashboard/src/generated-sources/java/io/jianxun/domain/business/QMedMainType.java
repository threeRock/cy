package io.jianxun.domain.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMedMainType is a Querydsl query type for MedMainType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMedMainType extends EntityPathBase<MedMainType> {

    private static final long serialVersionUID = 1242469578L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMedMainType medMainType = new QMedMainType("medMainType");

    public final io.jianxun.domain.QAbstractBusinessEntity _super;

    //inherited
    public final BooleanPath active;

    // inherited
    public final QUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate;

    //inherited
    public final NumberPath<Long> id;

    // inherited
    public final QUser lastModifieBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Long> version;

    public QMedMainType(String variable) {
        this(MedMainType.class, forVariable(variable), INITS);
    }

    public QMedMainType(Path<? extends MedMainType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMedMainType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMedMainType(PathMetadata metadata, PathInits inits) {
        this(MedMainType.class, metadata, inits);
    }

    public QMedMainType(Class<? extends MedMainType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new io.jianxun.domain.QAbstractBusinessEntity(type, metadata, inits);
        this.active = _super.active;
        this.createdBy = _super.createdBy;
        this.createdDate = _super.createdDate;
        this.id = _super.id;
        this.lastModifieBy = _super.lastModifieBy;
        this.lastModifiedDate = _super.lastModifiedDate;
        this.version = _super.version;
    }

}

