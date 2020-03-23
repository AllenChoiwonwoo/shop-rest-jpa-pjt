package codepresso.jpaShop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@Entity
@Table(name="announce", catalog="shop")
public class AnnounceVO {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="`order`")
	private int order;
	private String content;
	@Column(name = "`createdAt`")
//	, nullable=true
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

}
