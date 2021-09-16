package cake.tz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Date createdDate;
    private Date updatedDate;
//    @OneToMany(mappedBy = "category")
//    private List<Product> products;

}
