package codepresso.jpaShop.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@ToString(exclude= {"ProdDetailList","basketList"})
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
	@Column(name="`desc`")
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
	
	@OneToMany(mappedBy="productVO", fetch=FetchType.LAZY) // 이걸 LAZY(defaul)로 하면 그냥 그냥으로는 불로와 지지 않고 해당 컬럼을 가져오겠다고 명시해야만 가져오는것으로 보임
	// 연관관계의 주인은 테이블에 외래키가 있는 곳으로 정해야한다. = 여기선 ProdDetailVO 에 설정 "prodId" 로 설정된 변수 productVO 가 될 것이다.
	private List<ProductDetailVO> ProdDetailList = new ArrayList<ProductDetailVO>();
	
	@OneToMany(mappedBy="productVO", fetch= FetchType.EAGER)
	private List<BasketVO> basketList = new ArrayList<BasketVO>();
	
	public boolean getIsInBasket() {
		return this.isInBasket;
	}
}
