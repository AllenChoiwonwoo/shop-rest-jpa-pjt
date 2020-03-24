package codepresso.jpaShop.DTO;

import java.util.Date;

import org.springframework.stereotype.Component;

import codepresso.jpaShop.domain.ProductDetailVO;
import lombok.Data;

@Data
@Component
public class productDetailDTO {
	private int id;
	private int order;
	private String img;
	private String desc;
	private Date createdAt;
	
	public productDetailDTO(ProductDetailVO pdvo) {
//		super();
		this.id = pdvo.getId();
		this.order = pdvo.getOrder();
		this.img = pdvo.getImg();
		this.desc = pdvo.getDesc();
		this.createdAt = pdvo.getCreatedAt();
	}
	
	
}
