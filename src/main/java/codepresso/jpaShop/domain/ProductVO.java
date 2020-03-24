package codepresso.jpaShop.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@Entity
@Table(name = "production")
public class ProductVO {
	@Id
	@GeneratedValue
	@Column(name="id") // 이 컬럼이 productDetailVO 와 연결됨
	private int id;
	private String name;
	@Column(name="`mainImg`")
	private String mainImg;
	private String desc;
	private int price;
	@Column(name="`salePrice`")
	private int salePrice;
	@Column(name="`createdAt`")
	private Date createdAt;
	
	@Transient
	private boolean isInBasket = false;
	
//	@OneToMany(mappedBy="id")
//	private List<ProductDetailVO> prodDetailVOList = new ArrayList<ProductDetailVO>();
	
	
	
	
	
}
