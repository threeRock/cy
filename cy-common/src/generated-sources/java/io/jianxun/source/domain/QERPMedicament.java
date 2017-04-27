package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPMedicament is a Querydsl query type for ERPMedicament
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPMedicament extends EntityPathBase<ERPMedicament> {

    private static final long serialVersionUID = 1597191092L;

    public static final QERPMedicament eRPMedicament = new QERPMedicament("eRPMedicament");

    public final StringPath leibie = createString("leibie");

    public final StringPath spbh = createString("spbh");

    public final StringPath spid = createString("spid");

    public final StringPath spmch = createString("spmch");

    public final StringPath sptm = createString("sptm");

    public QERPMedicament(String variable) {
        super(ERPMedicament.class, forVariable(variable));
    }

    public QERPMedicament(Path<? extends ERPMedicament> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPMedicament(PathMetadata metadata) {
        super(ERPMedicament.class, metadata);
    }

}

