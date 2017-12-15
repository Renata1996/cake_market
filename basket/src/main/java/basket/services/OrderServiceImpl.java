package basket.services;

import basket.entities.Order;
import basket.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        orderRepository.findAll().forEach(orderList::add);
        return orderList;
    }

    @Override
    public Order getOrderByOrderId(Long id) {
        return orderRepository.findOrderByOrderId(id);
    }

    @Override
    public Order saveOrUpdate(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> getOrdersByUserName(String userName) {
        List<Order> orderList = new ArrayList<>();
        orderRepository.findOrdersByUserName(userName).forEach(orderList::add);
        return orderList;
    }
}
