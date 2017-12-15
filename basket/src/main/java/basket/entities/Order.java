package basket.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private String userName;
    private String address;
    private int price;
    private long cakeID;
    private boolean isPaid;


}
