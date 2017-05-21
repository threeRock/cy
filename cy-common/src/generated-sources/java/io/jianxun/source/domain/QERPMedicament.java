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

    public final StringPath beactive = createString("beactive");

    public final StringPath dw = createString("dw");

    public final StringPath is_jkyp = createString("is_jkyp");

    public final StringPath jingylb = createString("jingylb");

    public final StringPath jixing = createString("jixing");

    public final StringPath jiyao = createString("jiyao");

    public final StringPath khfl = createString("khfl");

    public final StringPath leibie = createString("leibie");

    public final NumberPath<java.math.BigDecimal> pfpj = createNumber("pfpj", java.math.BigDecimal.class);

    public final StringPath pizhwh = createString("pizhwh");

    public final StringPath shpchd = createString("shpchd");

    public final StringPath shpgg = createString("shpgg");

    public final StringPath spid = createString("spid");

    public final StringPath spmch = createString("spmch");

    public final StringPath yongyfl = createString("yongyfl");

    public final StringPath zbjg = createString("zbjg");

    public final StringPath zhilbz = createString("zhilbz");

    public final StringPath zhuzlx = createString("zhuzlx");

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

