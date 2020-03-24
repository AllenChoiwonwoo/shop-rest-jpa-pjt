package codepresso.jpaShop.Repository;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import codepresso.jpaShop.domain.ProductDetailVO;
import codepresso.jpaShop.domain.ProductVO;


@Repository
public class ProdDAO {
	
	String mapper = "mybatis.mapper.product.";
	public static Logger logger = LoggerFactory.getLogger(ProdDAO.class);
	@Autowired
	ProductDetailVO prodDetailVO;
//	@Autowired
//	SqlSession sqlsession;
	@Autowired
	ProductVO prodVO;
//	public List<ProdVO> getProdListWithUserid(ProdNumbAndTokenVO prodnumbntoken) {		
//		return sqlsession.selectList(mapper+"selectProdListWithBasketDelimiter", prodnumbntoken);
//	}
//	public List<ProdVO> getProdList(int lastProdId) {
//		return sqlsession.selectList(mapper+"selectProdList", lastProdId);
//	}
//	public List<ProdDetailVO> selectOneProdDetail(int prodid) {
//		List<ProdDetailVO> detailList = sqlsession.selectList(mapper+"selectProdDetailList", prodid);
//		return detailList;
//	}
//	public ProdVO selectOneProdMainInfo(ProdNumbAndTokenVO prodnumbntoken) {
//		logger.info(prodnumbntoken.getProdid() +" , userid ; "+ prodnumbntoken.getUserid());
//		return sqlsession.selectOne(mapper+"selectOneProdMainInfo", prodnumbntoken);
//		
//	}
	
	

}
