package io.jianxun.extend.domain.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderItem is a Querydsl query type for OrderItem
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QOrderItem extends BeanPath<OrderItem> {

    private static final long serialVersionUID = 994987770L;

    public static final QOrderItem orderItem = new QOrderItem("orderItem");

    public final StringPath quantity = createString("quantity");

    public final StringPath spid = createString("spid");

    public final StringPath spmch = createString("spmch");

    public QOrderItem(String variable) {
        super(OrderItem.class, forVariable(variable));
    }

    public QOrderItem(Path<? extends OrderItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderItem(PathMetadata metadata) {
        super(OrderItem.class, metadata);
    }

}

