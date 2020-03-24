package codepresso.jpaShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import codepresso.jpaShop.DTO.ResultVO;



@SpringBootApplication
public class ShopRestJpaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopRestJpaServerApplication.class, args);
//		SpringApplication application =
//				new SpringApplication(ShopRestJpaServerApplication.class);
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);
	}
	public static ResultVO returnSuccess(Object obj) {
		ResultVO rvo = new ResultVO();
		rvo.setCode(200);
		rvo.setMessage("Success");
		rvo.setData(obj);
		return rvo;
	}
	public static ResultVO returnError(Object obj) {
		ResultVO rvo = new ResultVO();
		rvo.setCode(500);
		rvo.setMessage("Fail");
		rvo.setData(obj);
		return rvo;
	}

}
