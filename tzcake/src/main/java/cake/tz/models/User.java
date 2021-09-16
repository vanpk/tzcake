package cake.tz.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String profileImageUrl;
    private String address;
    private Integer phone;
    private String description;
    private Date createdDate; // joinDate
    private Date updatedDate;
    private Date lastLoginDate;
    private Date lastingLoginDateDisplay;
    private String role; // USER, HR, MANAGER, ADMIN, SUPERADMIN
    private String[] authorities;
    private boolean isActive;
    private boolean isNotBlocked;
//    @OneToMany(mappedBy = "user")
//    private List<OrderProduct> orders;
//    @OneToMany(mappedBy = "user")
//    private List<UserRole> userRoles;
//    @OneToMany(mappedBy = "user")
//    private List<CartProduct> cartProducts;

    public User() {}

    public User(Long id, String userId, String firstName, String lastName, String username, String email, String password, String profileImageUrl, boolean isActive, boolean isNotBlocked, String address, Integer phone, String description, Date createdDate, Date updatedDate, Date lastLoginDate, Date lastingLoginDateDisplay, String role, String[] authorities/*, List<UserRole> userRoles, List<OrderProduct> orders, List<CartProduct> cartProducts*/) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.isActive = isActive;
        this.isNotBlocked = isNotBlocked;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.lastLoginDate = lastLoginDate;
        this.lastingLoginDateDisplay = lastingLoginDateDisplay;
        this.role = role;
        this.authorities = authorities;
//        this.orders = orders;
//        this.userRoles = userRoles;
//        this.cartProducts = cartProducts;
    }

//    public String[] getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(String[] authorities) {
//        this.authorities = authorities;
//    }
}
