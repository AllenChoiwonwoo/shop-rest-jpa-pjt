package codepresso.jpaShop.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import codepresso.jpaShop.ShopRestJpaServerApplication;
import codepresso.jpaShop.DTO.ResultVO;
import codepresso.jpaShop.DTO.TokenVO;
import codepresso.jpaShop.domain.UserVO;



@Repository
public class UserService {
	public static Logger logger = LoggerFactory.getLogger(UserService.class);
//	@Autowired
//	UserDAO userDao;
	@Autowired
	codepresso.jpaShop.Repository.UserRepo userRepo;


	public ResultVO addUser(UserVO uservo) {
		// TODO Auto-generated method stub
		ResultVO checkedResult = checkJoinable(uservo);
		if(checkedResult.getCode()!=200) {
			return checkedResult;
		}else {
			UserVO r_uservo = userRepo.insertOneUserInfo(uservo);
			checkedResult = ShopRestJpaServerApplication.returnSuccess("join success");
		}	
		return checkedResult;
	}
	
	public ResultVO checkJoinable(UserVO uservo) {

		if(!uservo.getPassword().equals(uservo.getPasswordConfirm())) {
			//비밀번호 불일치 - 회원가입 불가
			return ShopRestJpaServerApplication.returnError("비밀번호가 일치하지 않습니다.확인해주세요");
		}
		
		// 오늘 날짜를 구해서 7살 이하를 구분해내기 위한 코드
		java.util.Calendar cal = Calendar.getInstance();
		java.util.Date utilDate = new java.util.Date(); // your util date
		cal.setTime(utilDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.YEAR, -7);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime()); // your sql date
		
		int compare = uservo.getBirth().compareTo(sqlDate);
		if(compare < 0 ) {
			System.out.println(" 7세 이상");
		}else {
			System.out.println(" 7세 이하"); //- 회원가입 불가
			return ShopRestJpaServerApplication.returnError( "7세 이상부터 가입할 수 있습니다.");
		}
//		if(!userDao.checkEmail(uservo.getEmail())) {
//			return ShopRestJpaServerApplication.returnError("Email 이 중복되었습니다. 다른 이메일 주소를 적어주세요");
//
//		}
		
		return ShopRestJpaServerApplication.returnSuccess("ok");
		// 회원가입 가능
	}
	
	public ResultVO checkEmail(String email) {
		// TODO Auto-generated method stub
		List<Object[]> resultList = userRepo.checkEmailValidation(email);
		if (resultList.size() > 0 || resultList == null) {
			return ShopRestJpaServerApplication.returnError("중복된 이메일 입니다.");
			
		}else {
			return ShopRestJpaServerApplication.returnSuccess(email);
		}
//		if(isAvailableEmail) {
//			ResultVO resultVo = ShopRestServerApplication.returnSuccess(email);
//			return resultVo;
//		}else {
//			ShopRestServerApplication.errorResultVO.setData("중복된 이메일 입니다.");
//			return ShopRestServerApplication.errorResultVO;
//		}
	}


	
	
	
	public ResultVO login(UserVO uservo) throws Exception{
		// 1. 로그인(아이디비번체크) , 2.토큰체크(없으면 발행) , 2-1.발행한 토큰 저장, 3.결과값 반환
		UserVO resultUserVO = new UserVO();
		try { // 아이디 비번 체크
			List<Object[]> listUserVO = userRepo.checkUserInfoToLogin(uservo);
			resultUserVO.setEmail(listUserVO.get(0)[0].toString());
			resultUserVO.setPassword(listUserVO.get(0)[1].toString());
			logger.info("login , userid = "+ listUserVO.get(0)[0].toString());
		} catch (Exception e) { // 아이디 비번 불일치
			logger.info("login, 로그인 실페 - email & password 불일치 ");
			e.printStackTrace();
			return ShopRestJpaServerApplication.returnError("아이디와 비밀번호 불일치");
		}
//		return null;
		if(resultUserVO.getToken() != null) {// 이미 토큰이 있을 경우 있는 토큰 반환
			logger.info("login, 이미 토큰이 있을 경우 있는 토큰 반환");
			return ShopRestJpaServerApplication.returnSuccess(new TokenVO(resultUserVO.getToken()));
		}
//		return null;
//		// 토큰 없음, 발행 
		logger.info("login, 토큰 없음");
		try {
			resultUserVO = userRepo.insertTokenToUser(uservo.getEmail(), makeToken());
			logger.info("login, 발행 후 저장 후 토큰 반환 ");
			return ShopRestJpaServerApplication.returnSuccess(new TokenVO(resultUserVO.getToken()));
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("login, 토큰 저장 실패 ");
			e.printStackTrace();
			return ShopRestJpaServerApplication.returnError("로그인 실패 - 토큰 저장 실패");
		}
	}
	public static String makeToken(){
		int length = 8;
	  StringBuffer buffer = new StringBuffer();
//	  buffer.append(id+"");
	  Random random = new Random();
	  String chars[] =
	    "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
	 
	  for (int i=0 ; i<length ; i++)
	  {
	    buffer.append(chars[random.nextInt(chars.length)]);
	  }
	  return buffer.toString();
	}
	
	
	/*
	 * public static String makeToken(int id){ int length = 8; StringBuffer buffer =
	 * new StringBuffer(); buffer.append(id+""); Random random = new Random();
	 * String chars[] =
	 * "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
	 * 
	 * for (int i=0 ; i<length ; i++) {
	 * buffer.append(chars[random.nextInt(chars.length)]); } return
	 * buffer.toString(); }
	 */
	
	

}
