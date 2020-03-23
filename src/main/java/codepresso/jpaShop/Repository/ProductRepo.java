package codepresso.jpaShop.Repository;

import org.springframework.data.repository.CrudRepository;

import codepresso.jpaShop.domain.ProdVO;
import codepresso.jpaShop.domain.UserVO;

public interface ProductRepo extends CrudRepository<ProdVO, Integer>{
	
	@Query

}
