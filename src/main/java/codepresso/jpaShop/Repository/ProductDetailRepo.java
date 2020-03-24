package codepresso.jpaShop.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import codepresso.jpaShop.domain.ProductDetailVO;

public interface ProductDetailRepo extends CrudRepository<ProductDetailVO, Integer>{

//	List<ProductDetailVO> findByProdid();

}
