package codepresso.jpaShop.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class ProdVO {
	@Id
	@GeneratedValue
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
	@Transients
	private boolean isInBasket = false;
	
}
