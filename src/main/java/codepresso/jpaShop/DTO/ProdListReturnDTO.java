package codepresso.jpaShop.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import codepresso.jpaShop.domain.ProductVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class ProdListReturnDTO {
	private int userId;
	private List<ProductVO> prodListData;

}
