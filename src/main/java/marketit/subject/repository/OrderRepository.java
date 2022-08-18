package marketit.subject.repository;

import marketit.subject.api.dto.OrderResponseDto;
import marketit.subject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o join fetch o.orderItems oi join fetch oi.item WHERE o.id =:id ")
    Optional<Order> findOrderById(@Param("id") Long id);
}
