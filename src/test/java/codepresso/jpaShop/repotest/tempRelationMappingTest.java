package codepresso.jpaShop.repotest;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import codepresso.jpaShop.Repository.ProductDetailRepo;
import codepresso.jpaShop.Repository.ProductRepo;
import codepresso.jpaShop.Repository.UserRepo;
import codepresso.jpaShop.Repository.UtilRepo;
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
//		member1.
	@Test
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
			ProductDetailVO proddetailvo = new ProductDetailVO();
			proddetailvo.setProductVO(prodvo2);
			proddetailvo.setOrder(i);
			proddetailvo.setImg("상세이미지 "+i);
			proddetailvo.setDesc("상세 - 상품 설명 "+i);
			proddetailvo.setCreatedAt(new Date());
			proddetailrepo.save(proddetailvo);
		}
		
	}
	
}
