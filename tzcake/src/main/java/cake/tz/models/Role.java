package cake.tz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String role;
    private String description;
    private Date createdDate;
    private Date updatedDate;
/*    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;
    @OneToMany(mappedBy = "role")
    private List<WebActionRole> webActionRoles;*/

}
