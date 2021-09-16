package cake.tz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;
//    @ManyToOne
//    @JoinColumn(/*name = "id", */nullable=false)
//    private User user;
//    @ManyToOne
//    @JoinColumn(/*name = "id", */nullable=false)
//    private Role role;

}
