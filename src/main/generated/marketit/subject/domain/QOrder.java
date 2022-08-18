package marketit.subject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 815809581L;

    public static final QOrder order = new QOrder("order1");

    public final DateTimePath<java.time.LocalDateTime> acceptDate = createDateTime("acceptDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> completeDate = createDateTime("completeDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<OrderItem, QOrderItem> orderItems = this.<OrderItem, QOrderItem>createList("orderItems", OrderItem.class, QOrderItem.class, PathInits.DIRECT2);

    public final StringPath orderName = createString("orderName");

    public final EnumPath<OrderStatus> status = createEnum("status", OrderStatus.class);

    public final DateTimePath<java.time.LocalDateTime> waitDate = createDateTime("waitDate", java.time.LocalDateTime.class);

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    public QOrder(Path<? extends Order> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata metadata) {
        super(Order.class, metadata);
    }

}

