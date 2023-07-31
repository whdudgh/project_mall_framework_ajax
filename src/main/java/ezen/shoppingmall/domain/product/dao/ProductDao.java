package ezen.shoppingmall.domain.product.dao;

import java.sql.Connection;
import java.util.List;

import ezen.shoppingmall.domain.product.dto.Category;
import ezen.shoppingmall.domain.product.dto.Product;

/**
 * 데이터 베이스 상품 관리 명세
 * @author 문승욱
 *
 */
public interface ProductDao {
	
	public List<Category> findCategries(Connection connection);
	
	//일단 기능 1 카테고리에 맞는 이름을 가져오는 메소드(인자 카테고리명 리턴 리스트)
	// 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환
	List<Product> findAllByProduct(Connection connection, String category, int requestPage, int elementSize);
	
	//일단 기능 2 카테고리에서 상품명에 맞는 상품의 정보 가져오는 메소드(인자 상품명)
	Product findByName(Connection connection, String pName);
	
	// 페이징 계산에 필요한 게시글 전체 갯수 반환
	public int getCountAll(Connection connection, String categoryKey);
	
	
}
