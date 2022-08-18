package marketit.subject.api.dto;

import lombok.Getter;
import marketit.subject.domain.OrderItem;

@Getter
public class OrderItemResponseDto {
    private Long id;
    private String itemName;
    private int price;
    private int count;
    private int totalCount;

    public OrderItemResponseDto(OrderItem entity){
        this.id = entity.getId();
        this.itemName = entity.getItem().getName();
        this.price = entity.getOrderPrice();
        this.count = entity.getCount();
        this.totalCount = entity.getTotalPrice();
    }
}
