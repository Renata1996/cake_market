package basket.repositories;

import basket.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findOrderByOrderId(@Param("orderId") long orderId);

    List<Order> findOrdersByUserName(@Param("userName") String userName);

}

