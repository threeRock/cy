package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPMedicamentBatchKey is a Querydsl query type for ERPMedicamentBatchKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QERPMedicamentBatchKey extends BeanPath<ERPMedicamentBatchKey> {

    private static final long serialVersionUID = -45223783L;

    public static final QERPMedicamentBatchKey eRPMedicamentBatchKey = new QERPMedicamentBatchKey("eRPMedicamentBatchKey");

    public final StringPath pihao = createString("pihao");

    public final StringPath spid = createString("spid");

    public QERPMedicamentBatchKey(String variable) {
        super(ERPMedicamentBatchKey.class, forVariable(variable));
    }

    public QERPMedicamentBatchKey(Path<? extends ERPMedicamentBatchKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPMedicamentBatchKey(PathMetadata metadata) {
        super(ERPMedicamentBatchKey.class, metadata);
    }

}

