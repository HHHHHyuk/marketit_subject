package marketit.subject.service;

import lombok.RequiredArgsConstructor;
import marketit.subject.api.dto.OrderListResponseDto;
import marketit.subject.api.dto.OrderResponseDto;
import marketit.subject.api.dto.SearchCondition;
import marketit.subject.domain.Order;
import marketit.subject.exception.CustomException;
import marketit.subject.repository.ItemRepository;
import marketit.subject.repository.OrderQueryRepository;
import marketit.subject.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;

    @Transactional
    public Long accept(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new CustomException("해당 아이디 값을 가지고 있는 주문이 없습니다.  id : " + orderId));
        order.accept();
        return orderId;
    }

    @Transactional
    public Long complete(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new CustomException("해당 아이디 값을 가지고 있는 주문이 없습니다.  id : " + orderId));
        order.complete();
        return orderId;
    }

    public OrderResponseDto findById(Long orderId){
        Order order = orderRepository.findOrderById(orderId).orElseThrow(() -> new CustomException("해당 아이디 값을 가지고 있는 주문이 없습니다.  id : " + orderId));
        return new OrderResponseDto(order);
    }

    public List<OrderListResponseDto> findListBySearch(SearchCondition condition){
        return orderQueryRepository.findListBySearch(condition);
    }

}
