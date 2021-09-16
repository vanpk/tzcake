package cake.tz.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String imageUrl;
	private String ingredients;
	private BigDecimal purchasePrice;
	private String description;
	private String createdDate;
	private String updatedDate;
	private String model; // product version
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date releasedDate;
	@OneToMany(mappedBy = "product")
	private List<OrderProduct> orders;
//	@ManyToOne
//	@JoinColumn(/*name = "id", */nullable = false)
//	private Category category;
//	@OneToMany(mappedBy = "product")
//	private List<CartProduct> cartProducts;

}
