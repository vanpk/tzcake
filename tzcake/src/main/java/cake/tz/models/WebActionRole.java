package cake.tz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class WebActionRole {

    @Id
    @GeneratedValue
    private Long id;
//    @ManyToOne
//    @JoinColumn(/*name = "id", */nullable=false)
//    private WebAction webAction;
//    @ManyToOne
//    @JoinColumn(/*name = "id", */nullable=false)
//    private Role role;

}
