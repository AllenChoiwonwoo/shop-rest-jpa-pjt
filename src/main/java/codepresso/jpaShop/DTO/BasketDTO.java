package codepresso.jpaShop.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import codepresso.jpaShop.domain.BasketVO;
import lombok.Data;

@Data
@Component
//@Entity
public class BasketDTO {
	private int id;
	private int prodId;
	private int userId;
	private int prodVolumn;
	private Date createdAt;
	
	public BasketDTO() {
	}
	
	public BasketDTO(BasketVO bvo) {
	
		this.id = bvo.getId();
		this.prodId = bvo.getProductVO().getId();
		this.userId = bvo.getUserId();
		this.prodVolumn = bvo.getProdVolume();
		this.createdAt = bvo.getCreatedAt();
	}
	
	

}
