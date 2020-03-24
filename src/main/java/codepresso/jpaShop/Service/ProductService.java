package codepresso.jpaShop.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import codepresso.jpaShop.ShopRestJpaServerApplication;
import codepresso.jpaShop.DTO.PagedProdDTO;
import codepresso.jpaShop.DTO.ProdListReturnVO;
import codepresso.jpaShop.DTO.ProdNumbAndTokenVO;
import codepresso.jpaShop.DTO.ProductDTO;
import codepresso.jpaShop.DTO.ResultVO;
import codepresso.jpaShop.Repository.BasketRepo;
import codepresso.jpaShop.Repository.ProdDAO;
import codepresso.jpaShop.Repository.ProductRepo;
import codepresso.jpaShop.Repository.UserDAO;
import codepresso.jpaShop.Repository.UserRepo;
import codepresso.jpaShop.domain.BasketVO;
import codepresso.jpaShop.domain.ProductDetailVO;
import codepresso.jpaShop.domain.ProductVO;
import codepresso.jpaShop.domain.UserVO;


@Service
public class ProductService {
	public static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	UserDAO userdao;
	@Autowired
	ProdDAO proddao;

	
	@Autowired
	UserRepo userRepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	ProductDetailVO prodDetailVO;
	@Autowired
	BasketRepo basketRepo;
	
	@Transactional
	public ResultVO getProdList(ProdNumbAndTokenVO prodnumbntoken) {
		// TODO Auto-generated method stub
		// lastprodid 부터 6개의 상품을 정보를 받아서 보내준다.
		//  장바구니에 담은 상품이면 담기 가 아닌 보기로 화면에 보여질 수 있도록 해야한다.
		UserVO uservo = userRepo.findUserVOByToken(prodnumbntoken.getAccesstoken());

		int lastPage = 0;
		Pageable paging = PageRequest.of(lastPage, 6, Sort.Direction.ASC, "id");// (이것부터<limit> , 이거만큼<offset>, 정렬함수, 정렬기준 col)
		Page<ProductVO> prodPages = productRepo.findAll(paging);
		List<ProductVO> prodListPaged = prodPages.getContent();// 이거 prodList 그래돌 클라로 보내면 stackOverFlow 뜬다.
		System.out.println("prodListpaged.size = "+ prodListPaged.size());
		PagedProdDTO pagedProdDTO = new PagedProdDTO();
		pagedProdDTO.setSize(prodPages.getSize());
		pagedProdDTO.setTotalElements(prodPages.getTotalElements());
		pagedProdDTO.setTotalPages(prodPages.getTotalPages());

//		List<ProductDTO> prodDTOList = new ArrayList<ProductDTO>();
//		for (ProductVO productVO : prodListPaged) {
//			prodDTOList.add(new ProductDTO().setValue(productVO));
//		}
//		return ShopRestJpaServerApplication.returnSuccess(prodDTOList);
		List<ProductDTO> prodDTOList = new ArrayList<ProductDTO>();
		if(prodnumbntoken.getAccesstoken() != null) { // 로그인 중이라면
			// 이 for-for-if 문은 ProductVO 가 basketList 객체를 가지고 있기때문에 가능하고 
			// 결론적으로는 로그인한 유저가 해당 상품을 장바구니에 넣었는지 확인하기 위한 코드이다.
			// 확인후 각 productVO.isInBasket t/f를 에 넣는다.
			boolean isInBasket =false;// 초기설정
			
			for (ProductVO productVO : prodListPaged) {
				ProductDTO prodDTO = new ProductDTO();
				for (int i = 0; i < productVO.getBasketList().size(); i++) {
					if(productVO.getBasketList().get(i).getUserId() == uservo.getId()) {
						isInBasket = true;
						break;
					}
				}
				prodDTO.setInBasket(isInBasket);
				prodDTOList.add(prodDTO.setValue(productVO));// 클라로 보내기 위한 prodDTO객체에 결과값들을 담는다. 그리고 리스트에 넣는다. (
				isInBasket = false;// 초기화
			}
			// prodDTOList 완성 (inInBasket 도 다 들어 있음)
//			return ShopRestJpaServerApplication.returnSuccess(prodListPaged);
		}else {
			prodDTOList = new ArrayList<ProductDTO>();
			for (ProductVO productVO : prodListPaged) {
				prodDTOList.add(new ProductDTO().setValue(productVO));
			}
			// prodDTOList 의 모든 isInBasket 값은 false
//			return ShopRestJpaServerApplication.returnError(prodDTOList);
		}
		pagedProdDTO.setListProdDTO(prodDTOList);
		pagedProdDTO.setUserId(uservo.getId());
		return ShopRestJpaServerApplication.returnError(pagedProdDTO);
		
	}
	
//		prodlist = proddao.getProdList(prodnumbntoken.getLastProdId());
//		prodnumbntoken.setUserid(0);
//		List<ProdVO> prodlist =new ArrayList<ProdVO>();
//	
//		
//		if(prodnumbntoken.getAccesstoken() != null) {
//			
//			
////			int userid = userdao.selectOneUserByToken(prodnumbntoken.getAccesstoken());
//			int userid = (userdao.findUserVOByToken(prodnumbntoken.getAccesstoken())).getId();
//			productRepo
//			
//			prodnumbntoken.setUserid(userid);
//			prodlist= productRepo.getProdListWithUserid(prodnumbntoken);
//			
//		}else {
//			int LastPage = prodnumbntoken.getLastProdId();
//			// 로그인 안한경우 그냥 모든 product를 다 가져온다. (6개씩 pagging 해서)
//			
//		}
//		// 유저토큰과 함께 돌려보낸다. ( 그럼 프로트에서 유저 토큰과 함게오면 로그인 중인거로 인식 )
//		ProdListReturnVO prodListReturnVO = new ProdListReturnVO();
//		prodListReturnVO.setUserId(prodnumbntoken.getUserid());
//		prodListReturnVO.setProdListData(prodlist);
//		return ShopRestServerApplication.returnSuccess(prodListReturnVO);
//	}
//	
//	public ResultVO getProdDetail(ProdNumbAndTokenVO prodNumbAndTokenVO) {
//		List<ProdDetailVO> detailList = proddao.selectOneProdDetail(prodNumbAndTokenVO.getProdid());
//		ResultVO resultvo = ShopRestServerApplication.returnSuccess(detailList);
//		return resultvo;
//	}
//	
	// 8) 상품 상세페이지 - 메인정보
	public ResultVO getMainProdDetailInfo(ProdNumbAndTokenVO prodnumbntoken) {
		// TODO Auto-generated method stub
		UserVO uservo = userRepo.findUserVOByToken(prodnumbntoken.getAccesstoken());
//		prodnumbntoken.setProdid(3);
		ProductVO prodvo = productRepo.findById(prodnumbntoken.getProdid()).get();
		ProductDTO prodDTO = new ProductDTO();
		if(prodnumbntoken.getAccesstoken() != null) {//로그인 중일 경우
			logger.info("getMainProdDetailInfo . 로그인 중 "+uservo.getId());
			List<BasketVO> listBasketvo = basketRepo.findByUserId(uservo.getId());
			logger.info("getMainProdDetailInfo . listBakset.size = "+listBasketvo.size());
			for (BasketVO basketVO2 : listBasketvo) {
				logger.info("getMainProdDetailInfo . prodid 일치여부를 찾기위한 비교중");
				if (basketVO2.getProductVO().getId() == prodnumbntoken.getProdid() ) {
					prodDTO.setInBasket(true);//해당 상품을 유저가 장바구니에 담아놓음
					logger.info("getMainProdDetailInfo . pordid 일치 true 반환");
					break;
				}
			}
		}
		prodDTO.setValue(prodvo);// inInBasket 은default 가 false
		return ShopRestJpaServerApplication.returnSuccess(prodDTO);

	}
	
	

}

















