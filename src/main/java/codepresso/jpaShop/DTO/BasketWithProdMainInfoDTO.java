package codepresso.jpaShop.DTO;

import java.util.Date;

import org.springframework.stereotype.Component;

import codepresso.jpaShop.domain.BasketVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class BasketWithProdMainInfoDTO {
	private int id;
	private int prodId;
	private int userId;
	private String prodName;
	private String prodMainImg;
	private int prodPrice;
	private int prodSalePrice;
	private int prodVolume;
	private Date createdAt;
	
	public BasketWithProdMainInfoDTO(){
	}
	
	public BasketWithProdMainInfoDTO(BasketVO bvo) {
		super();
		this.id = bvo.getId();
		this.prodId = bvo.getProductVO().getId();
		this.userId = bvo.getUserId();
		this.prodName = bvo.getProductVO().getName();
		this.prodMainImg = bvo.getProductVO().getMainImg();
		this.prodPrice = bvo.getProductVO().getPrice();
		this.prodSalePrice = bvo.getProductVO().getSalePrice();
		this.prodVolume = bvo.getProdVolume();
		this.createdAt = bvo.getCreatedAt();
	}
	
	
}
