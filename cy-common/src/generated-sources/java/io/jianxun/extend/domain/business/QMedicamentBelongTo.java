package io.jianxun.extend.domain.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMedicamentBelongTo is a Querydsl query type for MedicamentBelongTo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMedicamentBelongTo extends EntityPathBase<MedicamentBelongTo> {

    private static final long serialVersionUID = -981229318L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMedicamentBelongTo medicamentBelongTo = new QMedicamentBelongTo("medicamentBelongTo");

    public final io.jianxun.extend.domain.QAbstractBusinessEntity _super;

    //inherited
    public final BooleanPath active;

    public final StringPath belongTo = createString("belongTo");

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

    public final NumberPath<java.math.BigDecimal> shl = createNumber("shl", java.math.BigDecimal.class);

    public final StringPath spid = createString("spid");

    //inherited
    public final NumberPath<Long> version;

    public QMedicamentBelongTo(String variable) {
        this(MedicamentBelongTo.class, forVariable(variable), INITS);
    }

    public QMedicamentBelongTo(Path<? extends MedicamentBelongTo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMedicamentBelongTo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMedicamentBelongTo(PathMetadata metadata, PathInits inits) {
        this(MedicamentBelongTo.class, metadata, inits);
    }

    public QMedicamentBelongTo(Class<? extends MedicamentBelongTo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new io.jianxun.extend.domain.QAbstractBusinessEntity(type, metadata, inits);
        this.active = _super.active;
        this.createdBy = _super.createdBy;
        this.createdDate = _super.createdDate;
        this.id = _super.id;
        this.lastModifieBy = _super.lastModifieBy;
        this.lastModifiedDate = _super.lastModifiedDate;
        this.version = _super.version;
    }

}

