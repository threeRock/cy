package io.jianxun.extend.domain.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMedicamentCatetory is a Querydsl query type for MedicamentCatetory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMedicamentCatetory extends EntityPathBase<MedicamentCatetory> {

    private static final long serialVersionUID = 1726518961L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMedicamentCatetory medicamentCatetory = new QMedicamentCatetory("medicamentCatetory");

    public final io.jianxun.extend.domain.QAbstractBusinessEntity _super;

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

    public QMedicamentCatetory(String variable) {
        this(MedicamentCatetory.class, forVariable(variable), INITS);
    }

    public QMedicamentCatetory(Path<? extends MedicamentCatetory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMedicamentCatetory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMedicamentCatetory(PathMetadata metadata, PathInits inits) {
        this(MedicamentCatetory.class, metadata, inits);
    }

    public QMedicamentCatetory(Class<? extends MedicamentCatetory> type, PathMetadata metadata, PathInits inits) {
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

