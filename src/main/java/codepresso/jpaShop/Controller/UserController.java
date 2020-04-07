package codepresso.jpaShop.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import codepresso.jpaShop.DTO.ResultDTO;
import codepresso.jpaShop.Service.UserService;
import codepresso.jpaShop.domain.UserVO;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	
	public static Logger logger = LoggerFactory.getLogger(UserController.class);

	// 2) 회원가입 api
	@PostMapping("/user/join")
	public ResultDTO joinUser(
			@RequestBody UserVO uservo) throws Exception {
		logger.info("joinUser, 호출됨");
		logger.info(uservo.toString());
		return userService.addUser(uservo);
	}

	//3) 아이디 중복 확인api
	@GetMapping("/user/emailConfirm")
	public ResultDTO emailConfirm(
			@RequestParam String email) throws Exception{
			logger.info("emailConfirm, 호출됨");
			ResultDTO resultvo = userService.checkEmail(email);
		return resultvo;
	}
	
	//4) 로그인 api ..
	@PostMapping("/user/login")
	public ResultDTO login(
			@RequestBody UserVO uservo,HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		logger.info("login, 호출됨");
		return userService.login(uservo);
	}

}
