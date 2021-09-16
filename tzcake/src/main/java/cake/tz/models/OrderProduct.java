package cake.tz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class OrderProduct {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Date orderDate;
//    @ManyToOne
//    @JoinColumn(/*name = "id", */nullable=false)
//    private User user;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private Product product;

}
