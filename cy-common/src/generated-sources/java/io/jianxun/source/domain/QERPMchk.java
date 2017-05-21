package io.jianxun.source.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QERPMchk is a Querydsl query type for ERPMchk
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QERPMchk extends EntityPathBase<ERPMchk> {

    private static final long serialVersionUID = 1358922740L;

    public static final QERPMchk eRPMchk = new QERPMchk("eRPMchk");

    public final StringPath dwbh = createString("dwbh");

    public final StringPath dwmch = createString("dwmch");

    public final StringPath jingyfw = createString("jingyfw");

    public final StringPath jslx = createString("jslx");

    public final StringPath khquyu = createString("khquyu");

    public final StringPath shouhdz = createString("shouhdz");

    public final StringPath xshlx = createString("xshlx");

    public final StringPath ywy = createString("ywy");

    public QERPMchk(String variable) {
        super(ERPMchk.class, forVariable(variable));
    }

    public QERPMchk(Path<? extends ERPMchk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QERPMchk(PathMetadata metadata) {
        super(ERPMchk.class, metadata);
    }

}

