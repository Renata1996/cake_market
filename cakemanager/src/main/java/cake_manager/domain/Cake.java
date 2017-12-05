package cake_manager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Cake {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;
    private int price;
    private String imageUrl;
    private String title;
}
