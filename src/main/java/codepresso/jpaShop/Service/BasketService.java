package codepresso.jpaShop.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codepresso.jpaShop.ShopRestJpaServerApplication;
import codepresso.jpaShop.Controller.BasketController;
import codepresso.jpaShop.DTO.BasketDTO;
import codepresso.jpaShop.DTO.BasketWithProdMainInfoDTO;
import codepresso.jpaShop.DTO.ResultVO;
import codepresso.jpaShop.Repository.BasketRepo;
import codepresso.jpaShop.Repository.ProductRepo;
import codepresso.jpaShop.Repository.UserRepo;
import codepresso.jpaShop.domain.BasketVO;
import codepresso.jpaShop.domain.ProductVO;
import codepresso.jpaShop.domain.UserVO;



@Service
public class BasketService {
	public static Logger logger = LoggerFactory.getLogger(BasketService.class);

//	
//	@Autowired
//	BasketDAO basketdao;
//	@Autowired
//	UserDAO userdao;
	@Autowired
	BasketRepo basketRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	ProductRepo prodRepo;
	
	// 10) 장바구니에 담기
	public ResultVO addOneProdToBasket(String accesstoken, BasketDTO basketDTO) {
//		int userid = userdao.selectOneUserByToken(accesstoken);
		UserVO uservo = userRepo.findUserVOByToken(accesstoken);
		ProductVO prodvo = prodRepo.findById(basketDTO.getProdId()).get();
		BasketVO basketvo = new BasketVO();
		basketvo.setUserId(uservo.getId());
		basketvo.setProductVO(prodvo);
		basketvo.setCreatedAt(new Date());
		BasketVO resultBVO;
		try {
			resultBVO = basketRepo.save(basketvo);
			logger.info("addOneProdToBasket , resultBVO = "+resultBVO.toString());
			return ShopRestJpaServerApplication.returnSuccess(prodvo.getId());
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("addOneProdToBasket , basket 에 데이터 넣기 실패");
			e.printStackTrace();
			return ShopRestJpaServerApplication.returnError("장바구니에 담기 실패 - 이미 담은 상품입니다.");
		}
		
		
	}
//  11) 장바구니 가져오기
	public ResultVO getAllFromBasket(String accesstoken) {
		UserVO uservo = userRepo.findUserVOByToken(accesstoken);
		List<BasketVO> listBasketvo = basketRepo.findByUserId(uservo.getId());
		BasketWithProdMainInfoDTO bifDTO = new BasketWithProdMainInfoDTO();
		List<BasketWithProdMainInfoDTO> resultlistbasket = new ArrayList<BasketWithProdMainInfoDTO>();
		for (BasketVO basketVO : listBasketvo) {
			bifDTO = new BasketWithProdMainInfoDTO(basketVO);
			resultlistbasket.add(bifDTO);
		}
		return ShopRestJpaServerApplication.returnSuccess(resultlistbasket);
	}
	
	// 12) 장바구니 빼기
	public ResultVO deleteOneProdFromBasket(String accesstoken, BasketDTO basketDTO) {
//		int userid = userdao.selectOneUserByToken(accesstoken);
		UserVO uservo = userRepo.findUserVOByToken(accesstoken);
		List<BasketVO> listbvo = basketRepo.findByUserId(uservo.getId());
		for (BasketVO basketVO2 : listbvo) {
			if(basketDTO.getProdId() == basketVO2.getProductVO().getId()) {
				basketRepo.delete(basketVO2);
				return ShopRestJpaServerApplication.returnSuccess(basketDTO.getProdId());
			}
		}
		return ShopRestJpaServerApplication.returnError(basketDTO.getProdId()+"은 회원님의 장바구니에 담겨있지 않습니다.");
	}
	

}
