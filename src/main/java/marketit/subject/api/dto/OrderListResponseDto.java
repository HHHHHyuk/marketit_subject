package marketit.subject.api.dto;

import lombok.Getter;
import marketit.subject.domain.Order;
import marketit.subject.domain.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderListResponseDto {
    private Long id;
    private String status;
    private String orderName;
    private LocalDateTime waitDate;
    private LocalDateTime acceptDate;
    private LocalDateTime completeDate;

    public OrderListResponseDto(Order entity){
        this.id = entity.getId();
        this.status = entity.getStatus().name();
        this.orderName = entity.getOrderName();
        this.waitDate = entity.getWaitDate();
        this.acceptDate = entity.getAcceptDate();
        this.completeDate = entity.getCompleteDate();
    }
}
