package basket.controllers;

import basket.entities.Order;
import basket.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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


    private static final String ORDER_USERNAME_PATH = "/orders/{username}";
    private static final String TYPE = "application/json";
    private static final String SHOW_ID_PATH = "/show/{id}";
    private static final String ADD_PATH = "/add";
    private static final String BUY_PATH = "/buy/{id}";
    private static final String VIEW_LIST_TEXT = "View a list of orders for user";
    private static final String SEARCH_TEXT = "Search an order with an ID";
    private static final String ADD_TEXT = "Add an order";
    private static final String UPDATE_TEXT = "Update an order";


    @Setter
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = VIEW_LIST_TEXT, response = Iterable.class)
    @RequestMapping(value = ORDER_USERNAME_PATH, method = RequestMethod.GET, produces = TYPE)
    public Iterable<Order> list(@PathVariable String username, Model model) {
        return orderService.getOrdersByUserName(username);
    }

    @ApiOperation(value = SEARCH_TEXT, response = Order.class)
    @RequestMapping(value = SHOW_ID_PATH, method = RequestMethod.GET, produces = TYPE)
    public Order showOrder(@PathVariable Long id, Model model) {
        return orderService.getOrderByOrderId(id);
    }

    @ApiOperation(value = ADD_TEXT)
    @RequestMapping(value = ADD_PATH, method = RequestMethod.POST, produces = TYPE)
    public ResponseEntity saveOrder(@RequestBody Order order) {
        orderService.saveOrUpdate(order);
        return new ResponseEntity(ADD_TEXT, HttpStatus.OK);
    }

    @ApiOperation(value = UPDATE_TEXT)
    @RequestMapping(value = BUY_PATH, method = RequestMethod.PUT, produces = TYPE)
    public ResponseEntity updateCake(@PathVariable Long id) {
        Order storedOrder = orderService.getOrderByOrderId(id);
        storedOrder.setPaid(true);
        orderService.saveOrUpdate(storedOrder);
        return new ResponseEntity(UPDATE_TEXT, HttpStatus.OK);
    }


}
