package codepresso.jpaShop.repotest;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import codepresso.jpaShop.Repository.BasketRepo;
import codepresso.jpaShop.Repository.ProductDetailRepo;
import codepresso.jpaShop.Repository.ProductRepo;
import codepresso.jpaShop.Repository.UserRepo;
import codepresso.jpaShop.Repository.UtilRepo;
import codepresso.jpaShop.domain.BasketVO;
import codepresso.jpaShop.domain.ProductDetailVO;
import codepresso.jpaShop.domain.ProductVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class tempRelationMappingTest {
	@Autowired
	private UtilRepo utilRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ProductRepo prodRepo;
	@Autowired
	private ProductDetailRepo proddetailrepo;
	@Autowired
	private BasketRepo basketRepo;
	@Autowired
	ProductRepo productRepo;
//		member1.
	/*
	@Test // @joinColunm 연습 용
	public void testManyToOneInsert() {
		ProductVO prodvo1 = new ProductVO();
		prodvo1.setName("상품1");
		prodvo1.setMainImg("이미지 주소 1");
		prodvo1.setDesc("메인- 상품 설명 1");
		prodvo1.setPrice(10000);
		prodvo1.setSalePrice(1000);
		prodvo1.setCreatedAt(new Date());
		prodRepo.save(prodvo1);
		
		ProductVO prodvo2 = new ProductVO();
		prodvo2.setName("상품1");
		prodvo2.setMainImg("이미지 주소 1");
		prodvo2.setDesc("메인- 상품 설명 1");
		prodvo2.setPrice(10000);
		prodvo2.setSalePrice(1000);
		prodvo2.setCreatedAt(new Date());
		prodRepo.save(prodvo2);
		
		for (int i = 1; i < 4; i++) {
			ProductDetailVO proddetailvo = new ProductDetailVO();
			proddetailvo.setProductVO(prodvo1);
			proddetailvo.setOrder(i);
			proddetailvo.setImg("상세이미지 "+i);
			proddetailvo.setDesc("상세 - 상품 설명 "+i);
			proddetailvo.setCreatedAt(new Date());
			proddetailrepo.save(proddetailvo);
		}
		
		for (int i = 1; i < 4; i++) {
			ProductDetailVO proddetailvo = new ProductDetailVO(); // prodDetailVO에 멤버 변수로 prodvo를 넣음으로서 객체 연관관계가 생긴다.
			proddetailvo.setProductVO(prodvo2);
			proddetailvo.setOrder(i);
			proddetailvo.setImg("상세이미지 "+i);
			proddetailvo.setDesc("상세 - 상품 설명 "+i);
			proddetailvo.setCreatedAt(new Date());
			proddetailrepo.save(proddetailvo);
		}
		
	}
	*/
	/*
	@Test // 상품의 상세정보를 조회함으로써 상품의 메인정보까지 얻어오기
	public void testManyToOneSelect() {
//		ProductVO prodvo = new ProductVO();
//		prodvo.get
		ProductDetailVO pdvo = proddetailrepo.findById(35).get();
		
		System.out.println("[ "+pdvo.getId()+"번 게시글 정보 ]");
		System.out.println("상세 설명 : "+pdvo.getDesc());
		System.out.println("상세 이미지주소 : "+pdvo.getImg());
		System.out.println("메인.상품이름 "+pdvo.getProductVO().getName());
		System.out.println("메인.상품가격 "+pdvo.getProductVO().getPrice());
	}
	*/
//	@Test // 장바구니 들어가서 상품 정보 가져올때
//	public void testManyToOneSelect2() {// basket 통해서 product 정보 가져오기
//		BasketVO bvo = basketRepo.findById(1).get();
//		System.out.println(" 상품 아이디 : " +bvo.getId());
//		System.out.println(" 유저 아이디 : "+ bvo.getUserId());
//		System.out.println(" 상품 명 : "+bvo.getProductVO().getName());
//	}
	
//	@Test //장바구니 에 있나 확인한 product list
//	@Transactional
//	public void testManyToOneSelect3() {
//		List<ProductVO> prodList = (List<ProductVO>) prodRepo.findAll();
////		System.out.println(prodList.size());
//		System.out.println(" 실행 결과 ");
//		for (ProductVO productVO : prodList) {
//			System.out.println("proid = "+ productVO.getId());
//			System.out.println( "prodName = "+ productVO.getName());
//			System.out.println("basketSize ="+ productVO.getBasketList().size());
//			List<BasketVO> basketList = productVO.getBasketList();
//			boolean isInBasket = false;
//			for (BasketVO basketvo : basketList) {
//				if(basketvo.getUserId() == 4 ) {
//					isInBasket = true;
//					break;
//				}
////				isInBasket = (basketvo.getUserId() == 1 )?true:false;
////				break;
//			}
//			System.out.println("isInbasket = "+isInBasket);
//			System.out.println(" ----------------------");
//		}
//	}
	
	@Test
	@Transactional
	public void softest() {
		int lastPage = 0;
		Pageable paging = PageRequest.of(lastPage, 6, Sort.Direction.ASC, "id");// (이것부터<limit> , 이거만큼<offset>, 정렬함수, 정렬기준 col)
		
		Page<ProductVO> prodPages = productRepo.findAll(paging);
		List<ProductVO> prodListPaged = prodPages.getContent();
		
		System.out.println("prodListpaged.size = "+ prodListPaged.size());
	}
	
	/*
	@Test // 상품 메인정보를 조회함으로써 상품의 상세정보들까지 조회하기
	@Transactional
	public void testTwoWayMapping() {
		ProductVO prodVO = prodRepo.findById(34).get();
//		List<ProductDetailVO> pdVOs = prodRepo.findById(34);
		
		System.out.println( "===================");
		System.out.println(prodVO.getName() + " 의 상품의 상세정보 들");
		System.out.println( "===================");
		List<ProductDetailVO> list = prodVO.getProdDetailList();
		System.out.println("상세정보 개수 list size = "+list.size());
		for (ProductDetailVO pdVO : list) {
			System.out.println(pdVO.toString());
		}
	}
	*/
}
