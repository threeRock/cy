package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPMedicamentKey is a Querydsl query type for ERPMedicamentKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QERPMedicamentKey extends BeanPath<ERPMedicamentKey> {

    private static final long serialVersionUID = -2022775285L;

    public static final QERPMedicamentKey eRPMedicamentKey = new QERPMedicamentKey("eRPMedicamentKey");

    public final StringPath spid = createString("spid");

    public QERPMedicamentKey(String variable) {
        super(ERPMedicamentKey.class, forVariable(variable));
    }

    public QERPMedicamentKey(Path<? extends ERPMedicamentKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPMedicamentKey(PathMetadata metadata) {
        super(ERPMedicamentKey.class, metadata);
    }

}

