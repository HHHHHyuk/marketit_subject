package marketit.subject.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id" )
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id" )
    private Order order;

    private int orderPrice;
    private int count;

    public OrderItem(Item item, int orderPrice, int count){
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }


    public int getTotalPrice(){
        return getOrderPrice() * getCount();
    }
}
