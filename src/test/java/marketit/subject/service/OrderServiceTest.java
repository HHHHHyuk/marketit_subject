package marketit.subject.service;

import marketit.subject.api.dto.OrderListResponseDto;
import marketit.subject.api.dto.OrderResponseDto;
import marketit.subject.api.dto.SearchCondition;
import marketit.subject.domain.Order;
import marketit.subject.domain.OrderStatus;
import marketit.subject.repository.ItemRepository;
import marketit.subject.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    public void accept_test(){
        //given
        Order order = orderRepository.findById(4L).orElseThrow();

        //when
        order.accept();

        //then
        assertThat(OrderStatus.ACCEPT).isEqualTo(order.getStatus());
    }

    @Test
    public void complete_test(){
        //given
        Order order = orderRepository.findById(5L).orElseThrow();

        //when
        order.complete();

        //then
        assertThat(OrderStatus.COMPLETE).isEqualTo(order.getStatus());
    }

    @Test
    public void findById_test() {
        //given
        Order order = orderRepository.findOrderById(4L).orElseThrow();

        //when
        OrderResponseDto dto = new OrderResponseDto(order);

        //then
        assertThat(dto.getStatus()).isEqualTo(OrderStatus.WAIT.toString());
        assertThat(dto.getId()).isEqualTo(4L);
        assertThat(dto.getOrderItemList().get(0).getItemName()).isEqualTo("과자");
    }

    @Test
    public void findListBySearch_test() {
        //given
        SearchCondition searchCondition = new SearchCondition();
        List<OrderListResponseDto> list1 = orderService.findListBySearch(searchCondition);

        searchCondition.setStatus(OrderStatus.COMPLETE.name());
        List<OrderListResponseDto> list2 = orderService.findListBySearch(searchCondition);

        //when

        //then
        assertThat(list1.size()).isEqualTo(2);
        assertThat(list2.size()).isEqualTo(1);
    }
}