package cake.tz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CartProduct {

    @Id
    @GeneratedValue
    private Long id;
    private Integer quantity;
//    @ManyToOne
//    @JoinColumn(/*name = "id", */nullable = false)
//    private User user;
//    @ManyToOne
//    @JoinColumn(/*name = "id", */nullable = false)
//    private Product product;

}
