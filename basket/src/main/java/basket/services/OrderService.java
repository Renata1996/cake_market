package basket.services;

import basket.entities.Order;

import java.util.List;

public interface OrderService {


    List<Order> getAllOrders();

    Order getOrderByOrderId(Long id);

    Order saveOrUpdate(Order order);

    List<Order> getOrdersByUserName(String userName);
}
