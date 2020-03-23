package codepresso.jpaShop.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TokenVO {
	private String token;
	
	public TokenVO() {
		
	}

	public TokenVO(String token) {
		super();
		this.token = token;
	}
	
}
