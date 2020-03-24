package codepresso.jpaShop.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import codepresso.jpaShop.domain.ProductDetailVO;
import codepresso.jpaShop.domain.ProductVO;
import codepresso.jpaShop.domain.UserVO;

public interface ProductRepo extends CrudRepository<ProductVO, Integer>{
//	Page<ProductVO> findAll(Pageable pageable);
	List<ProductDetailVO> findProdDetailListById(int id);
	Page<ProductVO> findAll(Pageable paging);
	
//	@Query

}
