package io.jianxun.extend.domain.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMedicament is a Querydsl query type for Medicament
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMedicament extends EntityPathBase<Medicament> {

    private static final long serialVersionUID = 2042514624L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMedicament medicament = new QMedicament("medicament");

    public final io.jianxun.extend.domain.QAbstractBusinessEntity _super;

    //inherited
    public final BooleanPath active;

    // inherited
    public final QUser createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate;

    public final StringPath erpSpid = createString("erpSpid");

    //inherited
    public final NumberPath<Long> id;

    // inherited
    public final QUser lastModifieBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate;

    public final StringPath mainPic = createString("mainPic");

    public final ListPath<String, StringPath> pics = this.<String, StringPath>createList("pics", String.class, StringPath.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> version;

    public final DateTimePath<java.time.LocalDateTime> zxq = createDateTime("zxq", java.time.LocalDateTime.class);

    public QMedicament(String variable) {
        this(Medicament.class, forVariable(variable), INITS);
    }

    public QMedicament(Path<? extends Medicament> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMedicament(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMedicament(PathMetadata metadata, PathInits inits) {
        this(Medicament.class, metadata, inits);
    }

    public QMedicament(Class<? extends Medicament> type, PathMetadata metadata, PathInits inits) {
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

