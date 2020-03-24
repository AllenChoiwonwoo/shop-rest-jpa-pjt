package codepresso.jpaShop.Repository;

import org.springframework.data.repository.CrudRepository;

import codepresso.jpaShop.domain.ProductVO;
import codepresso.jpaShop.domain.UserVO;

public interface ProductRepo extends CrudRepository<ProductVO, Integer>{
	
//	@Query

}
