package marketit.subject.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import marketit.subject.api.dto.OrderListResponseDto;
import marketit.subject.api.dto.OrderResponseDto;
import marketit.subject.api.dto.SearchCondition;
import marketit.subject.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

import static marketit.subject.domain.QOrder.*;

@Repository
public class OrderQueryRepository {
    private final JPAQueryFactory queryFactory;
    public OrderQueryRepository(EntityManager em){ this.queryFactory = new JPAQueryFactory(em);}

    public List<OrderListResponseDto> findListBySearch(SearchCondition condition){
        List<Order> query = queryFactory
                .select(order)
                .from(order)
                .where(
                        statusEq(condition.getStatus())
                )
                .fetch();

        return query.stream().map(OrderListResponseDto::new).collect(Collectors.toList());
    }


    private BooleanExpression statusEq(String status) {
        return status!=null  ? order.status.eq(OrderStatus.valueOf(status)) : null;
    }
}
