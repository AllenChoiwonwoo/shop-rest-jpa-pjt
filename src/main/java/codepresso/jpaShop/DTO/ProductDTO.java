package codepresso.jpaShop.DTO;

import java.util.Date;
import org.springframework.stereotype.Component;

import codepresso.jpaShop.domain.ProductVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
@Component
public class ProductDTO {

		private int id;
		private String name;
		private String mainImg;
		private String desc;
		private int price;
		private int salePrice;
		private Date createdAt;
		private boolean isInBasket;
		
		public ProductDTO setValue(ProductVO vo) {
			this.id = vo.getId();
			this.name = vo.getName();
			this.mainImg = vo.getMainImg();
			this.desc = vo.getDesc();
			this.price = vo.getPrice();
			this.salePrice = vo.getSalePrice();
			this.createdAt = vo.getCreatedAt();
//			this.isInBasket = vo.
			return this;
			
		}
}
