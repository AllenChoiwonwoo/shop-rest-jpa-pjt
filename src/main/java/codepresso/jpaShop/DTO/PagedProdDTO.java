package codepresso.jpaShop.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PagedProdDTO{
		// TODO Auto-generated method stub
	private int userId;
	private int size;
	private long totalElements;
	private int totalPages;
	private List<ProductDTO> listProdDTO;
	
//	public void setTotalElements(long totalElements) {
//		// TODO Auto-generated method stub
//		this.totalElements = totalElements;
//	}
//
//	public void setTotalPages(int totalPages) {
//		// TODO Auto-generated method stub
//		this.totalPages = totalPages;
//	}


}
