package codepresso.jpaShop.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import codepresso.jpaShop.domain.BasketVO;

public interface BasketRepo extends CrudRepository<BasketVO, Integer>{

	List<BasketVO> findByUserId(int userid);
}
