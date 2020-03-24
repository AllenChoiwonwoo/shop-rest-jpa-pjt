package codepresso.jpaShop.repotest;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import codepresso.jpaShop.Repository.UserRepo;
import codepresso.jpaShop.Repository.UtilRepo;
import codepresso.jpaShop.domain.AnnounceVO;
import codepresso.jpaShop.domain.UserVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class announceRepoTest {
	@Autowired
	private UtilRepo utilRepo;
	@Autowired
	private UserRepo userRepo;
	/*
	 * @Test public void testInsertAnnounce() { AnnounceVO announcevo = new
	 * AnnounceVO(); announcevo.setOrder(6); announcevo.setContent("6번째 jpa 공지사항");
	 * announcevo.setCreatedAt(new Date()); utilRepo.save(announcevo);
	 * 
	 * 
	 * }
	 */
//	
	
//	@Test
//	public void TestGetAnnounce() {
//		AnnounceVO ann = utilRepo.findById(2).get();
//		System.out.println(ann.toString());
//	}
	
//	@Test
//	public void testFindListAnnounce() {
//		Pageable paging = PageRequest.of(0, 4);
//		List<AnnounceVO> annList  = utilRepo.findByContent("5");
//		System.out.println("검색 결과");
//		for (AnnounceVO announceVO : annList) {
//			System.out.println("--> "+announceVO.toString());
//		}
//	}
	
//	@Test
//	public void testAnnounceList() {
//		Pageable paging = PageRequest.of(0, 4);// (이것부터<limit> , 이거만큼<offset>)
//		List<AnnounceVO> annList = utilRepo.announceListTest(paging);
//		
//		System.out.println(" 검색결과");
//		for (AnnounceVO announceVO : annList) {
//			System.out.println(announceVO.toString());
//		}
//	}
	
	/*
	 * @Test public void testAddUser() { UserVO uservo = new UserVO();
	 * uservo.setUsername("yeji"); uservo.setEmail("yeji3");
	 * uservo.setPassword("1212"); uservo.setBirth(new Date()); uservo.setGender(0);
	 * uservo.setCreatedAt(new Date()); UserVO result = userRepo.save(uservo);
	 * 
	 * }
	 */
//	@Test
//	public void testFindUserById() {
//		UserVO user = userRepo.findUserVOByEmail("1who");
//	}
	
//	@Test
//	public void testFindUserById2() {
//		List<Object[]> result = userRepo.checkEmailValidation("1who");
//		System.out.println("testFindUserById2 결과rkqt ");
//		System.out.println(result.size() + " 개 , get 0 ="+result.get(0).toString());
//	}
	
//	@Test
//	public void checkUserInfoToLogin() {
//		UserVO uservo = new UserVO();
//		uservo.setEmail("1who");
//		uservo.setPassword("1212");
////		UserVO resultVO = userRepo.checkUserInfoToLogin("1who", "1212");
//		List<Object[]> resultVO = userRepo.checkUserInfoToLogin(uservo);
//
//		System.out.println("결과 출력");
//		System.out.println("checkUserInfoToLogin = " + resultVO.size() +" & "+resultVO.get(0).toString());
//		
//		for (Object object : resultVO.get(0)) {
//			System.out.println( "checkUserInfoToLogin. "+object.toString());
//		}
//	}
	// commit test
	@Test
	public void insertTokenToUserTest() {
		UserVO uvo = userRepo.findUserVOByEmail("2who");
//		UserVO uvo = new UserVO();
		uvo.setEmail("2who");
		String newToken = "aaa1234567890";
//		logger.info("login, newToken = "+newToken);
		uvo.setToken(newToken);
		uvo.setBirth(new Date());
		uvo.setCreatedAt(new Date());
		uvo.setGender(0);
		uvo.setPassword("1111");
		uvo.setUsername("testCWW");
//		uvo.setEmail("2who");
		UserVO ruvo = userRepo.save(uvo);
		System.out.println("insertTokenToUserTest, "+uvo.toString());
//		UserVO resultUVO = userRepo.insertTokenToUser(uvo);
//		System.out.println("insertTokenToUserTest, "+resultUVO.toString());
	}
	

	

}
