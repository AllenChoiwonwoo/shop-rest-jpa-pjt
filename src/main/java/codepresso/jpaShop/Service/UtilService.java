package codepresso.jpaShop.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import codepresso.jpaShop.ShopRestJpaServerApplication;
import codepresso.jpaShop.DTO.ResultVO;
import codepresso.jpaShop.Repository.UtilDAO;
import codepresso.jpaShop.Repository.UtilRepo;
import codepresso.jpaShop.domain.AnnounceVO;



@Service
public class UtilService {
	
	public static Logger logger = LoggerFactory.getLogger(UtilService.class);
//	@Autowired
//	UtilDAO utilDao;
	@Autowired
	UtilRepo utilRepo;

	public ResultVO getAllAnnouces() {
//		List<AnnounceVO> resultList = utilDao.selectAnnounces();
//		return ShopRestJpaServerApplication.returnSuccess(resultList);
//		List<AnnounceVO> resultList = utilRepo.findAll().get();
		
			Pageable paging = PageRequest.of(0, 4, Sort.Direction.ASC, "order");// (이것부터<limit> , 이거만큼<offset>)
//			List<AnnounceVO> annList = utilRepo.announceListTest(paging);
			Page<AnnounceVO> pageResult = utilRepo.findAll(paging);// 자세한 설명은 교제 287페이지
			
			System.out.println(" 검색결과");
			System.out.println( "한 페이지의 크기 "+pageResult.getSize());
			System.out.println( "한 전체 페이지수 "+pageResult.getTotalElements());
			System.out.println( "결과페이지 수 "+pageResult.getTotalElements());
			pageResult.toString();
			List<AnnounceVO> announceListLimited4 = pageResult.getContent();
			
			for (AnnounceVO announceVO : announceListLimited4) {
				System.out.println(" ----------------- ");
				System.out.println(announceVO.toString());
			}
		
		return ShopRestJpaServerApplication.returnSuccess(announceListLimited4);
	}

}
