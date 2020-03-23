package codepresso.jpaShop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@Entity
@Table(name="user")
public class UserVO {

	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String username;
	private Date birth;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String password;
	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String passwordConfirm;
	private int gender;
	private String token;
	@Column(name = "`createdAt`")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

}
