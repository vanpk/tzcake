package cake.tz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class WebAction {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
//    @OneToMany(mappedBy = "webAction")
//    private List<WebActionRole> webActionRoles;

}
