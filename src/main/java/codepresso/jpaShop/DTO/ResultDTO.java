package codepresso.jpaShop.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResultDTO {
	private int code;
	private String message;
	private Object data;

}
