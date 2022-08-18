package marketit.subject.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL )
    private List<OrderItem> orderItems = new ArrayList<>();

    private String orderName; //주문명
    private LocalDateTime waitDate; //접수대기 일자
    private LocalDateTime acceptDate; //접수일자
    private LocalDateTime completeDate; //완료일자

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    // 주문 접수
    public void accept(){
        if(this.status==OrderStatus.ACCEPT){
            throw new IllegalStateException("이미 주문이 접수된 상태입니다.");
        }
        this.status = OrderStatus.ACCEPT;
        this.acceptDate = LocalDateTime.now();
    }

    // 주문 완료
    public void complete(){
        if(this.status==OrderStatus.COMPLETE){
            throw new IllegalStateException("이미 주문이 완료된 상태입니다.");
        }
        this.status = OrderStatus.COMPLETE;
        this.completeDate = LocalDateTime.now();
    }

}
