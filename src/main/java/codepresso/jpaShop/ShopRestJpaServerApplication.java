package codepresso.jpaShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import codepresso.jpaShop.DTO.ResultDTO;


@SpringBootApplication
public class ShopRestJpaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopRestJpaServerApplication.class, args);
//		SpringApplication application =
//				new SpringApplication(ShopRestJpaServerApplication.class);
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);
	}
	public static ResultDTO returnSuccess(Object obj) {
		ResultDTO rvo = new ResultDTO();
		rvo.setCode(200);
		rvo.setMessage("Success");
		rvo.setData(obj);
		return rvo;
	}
	public static ResultDTO returnError(Object obj) {
		ResultDTO rvo = new ResultDTO();
		rvo.setCode(500);
		rvo.setMessage("Fail");
		rvo.setData(obj);
		return rvo;
	}
	
//	@Bean
//	public WebMvcConfigurer webMvcConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCrosMappings(CrosRegistery registry)
//		}
//	}
	@Configuration
	public class WebConfig implements WebMvcConfigurer{
		
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
				.allowedOrigins("http://localhost:8081","http://localhost:8080")
				.allowedMethods(
						HttpMethod.GET.name(),
						HttpMethod.POST.name(),
						HttpMethod.PUT.name(),
						HttpMethod.DELETE.name()
						);
		}
	}

}
