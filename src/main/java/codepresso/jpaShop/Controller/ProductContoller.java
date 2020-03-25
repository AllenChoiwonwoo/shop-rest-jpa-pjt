package codepresso.jpaShop.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import codepresso.jpaShop.ShopRestJpaServerApplication;
import codepresso.jpaShop.DTO.ProdNumbAndTokenDTO;
import codepresso.jpaShop.DTO.ResultDTO;
import codepresso.jpaShop.Service.ProductService;


@RestController
public class ProductContoller {
	
	public static Logger logger = LoggerFactory.getLogger(ProductContoller.class);
	@Autowired
	ProductService productService;
	
	// 7) 상품 더보기 
	@RequestMapping(value = {"/product/list/offset/{lastPordId}"}, method=RequestMethod.GET)
	public ResultDTO getProdListForMain(
			@PathVariable("lastPordId") int lastProdId,
			@RequestHeader(value="accesstoken", required=false) String accesstoken,
			HttpServletRequest request, HttpServletResponse response) {
			
		logger.info("getProdListForMain , called ,token = "+accesstoken+", lastpostid = "+lastProdId);
		ProdNumbAndTokenDTO prodnumbntoken = new ProdNumbAndTokenDTO();
		prodnumbntoken.setAccesstoken(accesstoken);
		prodnumbntoken.setLastProdId(lastProdId);
		return productService.getProdList(prodnumbntoken);
	}
	// 8) 상품 상세페이지 - 메인정보
	@RequestMapping(value="/product/detail/{prodId}/main", method=RequestMethod.GET)
	public ResultDTO getMainProdDetailInfo(
			@PathVariable("prodId") int prodId,
			@RequestHeader(value="accesstoken", required=false) String accesstoken
			) {
		logger.info("getMainProdDetailInfo , prodId ="+prodId);
		ProdNumbAndTokenDTO prodnumbntoken = new ProdNumbAndTokenDTO();
		prodnumbntoken.setAccesstoken(accesstoken);
		prodnumbntoken.setProdid(prodId);
		return productService.getMainProdDetailInfo(prodnumbntoken);

	}

	//9) 상품 상세페이지 - 상세정보
	@RequestMapping(value = "/product/detail/{prodId}/info", method=RequestMethod.GET)
	public ResultDTO getProdDetail(
//			@RequestParam int prodId
			@PathVariable("prodId") int prodId
			) {
		logger.info("getProdDetail, prodId = "+prodId+"prodId" );
		if(0 == prodId) {
			ShopRestJpaServerApplication.returnError("prodId : 0 은 존제하지 않는 상품입니다.");
		}
		ProdNumbAndTokenDTO prodNumbAndTokenDTO = new ProdNumbAndTokenDTO();
		prodNumbAndTokenDTO.setProdid(prodId);
		return productService.getProdDetail(prodNumbAndTokenDTO);
	}
	
	
	
}
