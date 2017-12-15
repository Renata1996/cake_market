package basket.controllers;

import basket.entities.Order;
import basket.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
@Api(value = "onlinestore", description = "Operations pertaining to basket in Online Store")
public class OrderController {

    @Setter
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "View a list of orders for user", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/orders/{username}", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Order> list(@PathVariable String username, Model model) {
        Iterable<Order> orderList = orderService.getOrdersByUserName(username);
        return orderList;
    }

    @ApiOperation(value = "Search an order with an ID", response = Order.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public Order showOrder(@PathVariable Long id, Model model) {
        Order order= orderService.getOrderByOrderId(id);
        return order;
    }

    @ApiOperation(value = "Add an order")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveOrder(@RequestBody Order order) {
        orderService.saveOrUpdate(order);
        return new ResponseEntity("Order saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update an order")
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateCake(@PathVariable  Long id) {
        Order storedOrder = orderService.getOrderByOrderId(id);
        storedOrder.setPaid(true);
        orderService.saveOrUpdate(storedOrder);
        return new ResponseEntity("You bought cake successfully", HttpStatus.OK);
    }


}
