package codepresso.jpaShop.Repository;

//import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import codepresso.jpaShop.domain.AnnounceVO;

public interface UtilRepo extends CrudRepository<AnnounceVO, Integer>{
//	List<AnnounceVO> findByContent(String content);
	Page<AnnounceVO> findAll(Pageable pageable);
	
//	+" ORDER BY a.order DESC" )
//	+" LIMIT 3 OFFSET %:offset% ")
	// 공지사항
	/*
	 * @Query("SELECT a FROM AnnounceVO a "+" ORDER BY a.order ASC" )
	 * List<AnnounceVO> announceListTest(Pageable pageable);
	 */
}
