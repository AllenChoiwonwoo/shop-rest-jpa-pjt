package codepresso.jpaShop.DTO;

import lombok.Data;

@Data
public class ProdNumbAndTokenVO {
	private String accesstoken;
	private int lastProdId;
	private int userid;
	private int prodid;
}
