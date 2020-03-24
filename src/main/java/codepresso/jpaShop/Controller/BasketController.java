package codepresso.jpaShop.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import codepresso.jpaShop.DTO.BasketDTO;
import codepresso.jpaShop.DTO.ResultVO;
import codepresso.jpaShop.Service.BasketService;
import codepresso.jpaShop.domain.BasketVO;


@RestController
public class BasketController {
	public static Logger logger = LoggerFactory.getLogger(BasketController.class);
	@Autowired
	BasketService basketService;
	
	
	// 10) 장바구니에 담기
	@PostMapping("/basket")
	public ResultVO addToBasket(
			@RequestHeader(value="accesstoken", required=false) String accesstoken,
			@RequestBody BasketDTO basketDTO
			) {
//		System.out.println(accesstoken+" buket  "+basketvo.toString());
		return basketService.addOneProdToBasket(accesstoken,basketDTO);
	}
	//  11) 장바구니 가져오기
	@GetMapping("/basket")
	public ResultVO getAllFromBasket(
			@RequestHeader(value="accesstoken", required=false) String accesstoken
			) {
				return basketService.getAllFromBasket(accesstoken);
			}
	
	// 12) 장바구니 빼기
	@DeleteMapping("/basket")
	public ResultVO deleteFromBasket(
			@RequestHeader(value="accesstoken", required=false) String accesstoken,
			@RequestBody BasketDTO basketDTO
			) {
		
//		System.out.println(accesstoken+" basket  "+basketvo.toString());
		return basketService.deleteOneProdFromBasket(accesstoken, basketDTO);
	}
}
