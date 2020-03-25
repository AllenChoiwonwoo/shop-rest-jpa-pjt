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
import codepresso.jpaShop.DTO.ResultDTO;
import codepresso.jpaShop.Repository.UtilRepo;
import codepresso.jpaShop.domain.AnnounceVO;



@Service
public class UtilService {
	
	public static Logger logger = LoggerFactory.getLogger(UtilService.class);
//	@Autowired
//	UtilDAO utilDao;
	@Autowired
	UtilRepo utilRepo;

	public ResultDTO getAllAnnouces() {
		
			Pageable paging = PageRequest.of(0, 4, Sort.Direction.ASC, "order");// (이것부터<limit> , 이거만큼<offset>)
//			List<AnnounceVO> annList = utilRepo.announceListTest(paging);
			Page<AnnounceVO> pageResult = utilRepo.findAll(paging);// 자세한 설명은 교제 287페이지
			
//			pageResult.toString();
			List<AnnounceVO> announceListLimited4 = pageResult.getContent();
			
		return ShopRestJpaServerApplication.returnSuccess(announceListLimited4);
	}

}
