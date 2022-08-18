package marketit.subject.api;

import lombok.RequiredArgsConstructor;
import marketit.subject.api.dto.OrderListResponseDto;
import marketit.subject.api.dto.OrderResponseDto;
import marketit.subject.api.dto.SearchCondition;
import marketit.subject.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PutMapping("/api/orders/{id}/accept")
    public Long accept(@PathVariable("id") Long id){
        return orderService.accept(id);
    }

    @PutMapping("/api/orders/{id}/complete")
    public Long complete(@PathVariable("id") Long id){
        return orderService.complete(id);
    }

    @GetMapping("/api/orders/{id}")
    public OrderResponseDto orders(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

    @GetMapping("/api/orders")
    public List<OrderListResponseDto> orders(SearchCondition searchCondition){
        return orderService.findListBySearch(searchCondition);
    }
}
