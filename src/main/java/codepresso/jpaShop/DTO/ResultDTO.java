package codepresso.jpaShop.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Component
public class ResultVO {
	private int code;
	private String message;
	private Object data;

}
