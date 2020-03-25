package codepresso.jpaShop.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import codepresso.jpaShop.domain.ProductDetailVO;
import codepresso.jpaShop.domain.ProductVO;

public interface ProductRepo extends CrudRepository<ProductVO, Integer>{
	List<ProductDetailVO> findProdDetailListById(int id);
	Page<ProductVO> findAll(Pageable paging);
}