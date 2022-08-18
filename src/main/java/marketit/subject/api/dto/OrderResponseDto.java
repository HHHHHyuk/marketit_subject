package marketit.subject.api.dto;

import lombok.Getter;
import marketit.subject.domain.Order;
import marketit.subject.domain.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderResponseDto {
    private Long id;
    private String status;
    private String orderName;
    private LocalDateTime waitDate;
    private LocalDateTime acceptDate;
    private LocalDateTime completeDate;
    private List<OrderItemResponseDto> orderItemList = new ArrayList<>();

    public OrderResponseDto(Order entity){
        this.id = entity.getId();
        this.status = entity.getStatus().name();
        this.orderName = entity.getOrderName();
        this.waitDate = entity.getWaitDate();
        this.acceptDate = entity.getAcceptDate();
        this.completeDate = entity.getCompleteDate();
        for(OrderItem orderItem : entity.getOrderItems()){
            orderItemList.add(new OrderItemResponseDto(orderItem));
        }
    }
}
