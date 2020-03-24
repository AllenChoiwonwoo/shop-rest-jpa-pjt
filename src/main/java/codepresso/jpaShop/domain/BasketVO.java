package codepresso.jpaShop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="productVO")
@Component
@Entity
@Table(name="basket")
public class BasketVO {
	@Id
	@GeneratedValue
	private int id;
//	@Column(name="`prodId`")
//	private int prodId;
	@Column(name="`userId`")
	private int userId;
	@Column(name="`prodVolume`")
	private int prodVolume;
	@Column(name="`createdAt`")
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="`prodId`", nullable=true)
	private ProductVO productVO;
}
