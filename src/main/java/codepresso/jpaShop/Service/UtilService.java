package codepresso.jpaShop.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		
			Pageable paging = PageRequest.of(0, 4);// (이것부터<limit> , 이거만큼<offset>)
			List<AnnounceVO> annList = utilRepo.announceListTest(paging);
			
			System.out.println(" 검색결과");
			for (AnnounceVO announceVO : annList) {
				System.out.println(announceVO.toString());
			}
		
		return ShopRestJpaServerApplication.returnSuccess(annList);
	}

}
