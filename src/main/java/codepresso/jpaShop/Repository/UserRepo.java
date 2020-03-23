package codepresso.jpaShop.Repository;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import codepresso.jpaShop.ShopRestJpaServerApplication;
import codepresso.jpaShop.domain.UserVO;

public interface UserRepo extends CrudRepository<UserVO, Integer>{
//	int addNewMember(UserVO uservo);
	public default UserVO insertOneUserInfo(UserVO uservo) {
		
		UserVO result = this.save(uservo);
		
		System.out.println("결과 출력");
//		System.out.print("-->"+Arrays.toString()));
		System.out.println(result.toString());
		return result;
	}

//	public default void checkEmail(String email) {
//		this.findUserVOByEmail(email);
//	}
	
	UserVO findUserVOByEmail(String email);
//	void updateUserVO(UserVO uservo);
	
	@Query("SELECT u.id FROM UserVO u WHERE u.email = :#{#email} ")
	List<Object[]> checkEmailValidation(@Param("email") String email);

	@Query("SELECT u.id, u.token "
			+ "FROM UserVO u "
			+ "WHERE u.email = :#{#uservo.email} AND u.password = :#{#uservo.password}")
	List<Object[]> checkUserInfoToLogin(@Param("uservo") UserVO uservo);
	
	default UserVO insertTokenToUser(String email, String token) {
		UserVO uvo = this.findUserVOByEmail(email);
//		uvo.setEmail("2who");
		String newToken = uvo.getId()+token;
//		logger.info("login, newToken = "+newToken);
//		uvo.setToken(newToken);
//		uvo.setBirth(new Date());
//		uvo.setCreatedAt(new Date());
//		uvo.setGender(0);
//		uvo.setPassword("1111");
//		uvo.setUsername("testCWW");
//		uvo.setEmail("2who");
		UserVO ruvo = this.save(uvo);
		System.out.println("insertTokenToUserTest, "+uvo.toString());
//		UserVO resultUVO = userRepo.insertTokenToUser(uvo);
//		System.out.println("insertTokenToUserTest, "+resultUVO.toString());
		return ruvo;
	}
	
	UserVO findUserVOByToken(String token);
//	@Query("SELECT u.id FROM UserVO u WHERE u.token = :#{#token}")
//	List<Object> selectOneUserByToken(String token) 
	

	
//	@Modifying
//	@Transactional
//	@Query("UPDATE UserVO u SET u.token = :#{#uservo.token} WHERE email = :#{#uservo.email}")
//	UserVO insertTokenToUser(@Param("uservo") UserVO uservo);
}