package codepresso.jpaShop.Repository;

import org.springframework.data.repository.CrudRepository;
import codepresso.jpaShop.domain.UserVO;

public interface UserRepo extends CrudRepository<UserVO, Integer>{
//	int addNewMember(UserVO uservo);
	// 회원 추가
	public default UserVO insertOneUserInfo(UserVO uservo) {
		
		UserVO ruvo = this.save(uservo);
		
		System.out.println("결과 출력");
		System.out.println(ruvo.toString());
		return ruvo;
	}
	
	UserVO findUserVOByEmail(String email);	
	UserVO findByEmail(String email);
	UserVO findById(int id);
	UserVO findByEmailAndPassword(String email, String password);
	
	UserVO findUserVOByToken(String token);
	
	
//	@Query("SELECT u.id FROM UserVO u WHERE u.token = :#{#token}")
//	List<Object> selectOneUserByToken(String token) 
	

	/*	@Query("SELECT u.id, u.token "
	+ "FROM UserVO u "
	+ "WHERE u.email = :#{#uservo.email} AND u.password = :#{#uservo.password}")
	List<Object[]> checkUserInfoToLogin(@Param("uservo") UserVO uservo);
*/
	/*	//이거 열심히 만든건데 ..아까워서 남길거야.. ㅠㅜ
	@Query("SELECT u.id FROM UserVO u WHERE u.email = :#{#email} ")
	List<Object[]> checkEmailValidation(@Param("email") String email);
*/
	
//	@Modifying
//	@Transactional
//	@Query("UPDATE UserVO u SET u.token = :#{#uservo.token} WHERE email = :#{#uservo.email}")
//	UserVO insertTokenToUser(@Param("uservo") UserVO uservo);
}