package codepresso.jpaShop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString( exclude="productVO")
@Component
@Entity
@Table(name="`prodDetail`")
public class ProductDetailVO {
	@Id
	@GeneratedValue
	private int id;
//	@ManyToOne // 이 pordId 컬럼이 productVO.id 와 연결된다.
//	@JoinColumn(name="id")
//	@Column(name="`prodId`")
//	private int prodId;
	@Column(name="`order`")
	private int order;
	private String img;
	@Column(name="`desc`")
	private String desc;
	@Column(name="`createdAt`")
	private Date createdAt;
	@Transient
	private int prodDetail;
//	
//	@Column(name="prodId")
	@ManyToOne
	@JoinColumn(name="`prodId`" , nullable=false)
	private ProductVO productVO;
}
