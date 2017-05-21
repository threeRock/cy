package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QERPMedicamentBatch is a Querydsl query type for ERPMedicamentBatch
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPMedicamentBatch extends EntityPathBase<ERPMedicamentBatch> {

    private static final long serialVersionUID = 1724703718L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QERPMedicamentBatch eRPMedicamentBatch = new QERPMedicamentBatch("eRPMedicamentBatch");

    public final QERPMedicamentBatchKey batchKey;

    public final NumberPath<java.math.BigDecimal> gebjj = createNumber("gebjj", java.math.BigDecimal.class);

    public final StringPath jwh = createString("jwh");

    public final StringPath pihao = createString("pihao");

    public final StringPath pihao2 = createString("pihao2");

    public final NumberPath<java.math.BigDecimal> shl = createNumber("shl", java.math.BigDecimal.class);

    public final StringPath sxrq = createString("sxrq");

    public QERPMedicamentBatch(String variable) {
        this(ERPMedicamentBatch.class, forVariable(variable), INITS);
    }

    public QERPMedicamentBatch(Path<? extends ERPMedicamentBatch> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QERPMedicamentBatch(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QERPMedicamentBatch(PathMetadata metadata, PathInits inits) {
        this(ERPMedicamentBatch.class, metadata, inits);
    }

    public QERPMedicamentBatch(Class<? extends ERPMedicamentBatch> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.batchKey = inits.isInitialized("batchKey") ? new QERPMedicamentBatchKey(forProperty("batchKey")) : null;
    }

}

