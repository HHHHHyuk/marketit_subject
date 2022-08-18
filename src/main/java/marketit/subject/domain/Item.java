package marketit.subject.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import marketit.subject.exception.CustomException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name; // 아이템 이름
    private int price; // 가격
    private int stockQuantity;

    @Builder
    public Item(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }


    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new CustomException("재고 수량이 부족합니다.");
        }
        this.stockQuantity = restStock;
    }
}
