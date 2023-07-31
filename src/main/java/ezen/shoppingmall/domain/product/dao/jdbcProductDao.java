package ezen.shoppingmall.domain.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ezen.shoppingmall.domain.product.dto.Category;
import ezen.shoppingmall.domain.product.dto.Product;

/**
 * RDB를 통해 상품관련 기능 구현체
 * 
 * @author 문승욱
 *
 */
public class jdbcProductDao implements ProductDao {

	public List<Product> findAllByProduct(Connection connection, String category, int requestPage, int elementSize) {
		List<Product> resultList = null;

		// 기능 구현 시작
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT page, c_name,  p_name, price, main_img")
		  .append(" FROM( SELECT ceil(ROWNUM / ?) page, c_name,  p_name, price, main_img")
		  .append("      FROM ( SELECT c_name, p_name, price, main_img")
		  .append("             FROM product p JOIN category c ON p.category_key = c.category_key")
		  .append("             WHERE p.category_key= ?)")
		  .append("      )")
		  .append("WHERE page = ?");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setInt(1, elementSize);
			pstmt.setString(2, category);
			pstmt.setInt(3, requestPage);

			rs = pstmt.executeQuery();
			resultList = new ArrayList<Product>();
			while (rs.next()) {
				String categoryName = rs.getString("c_name");
				String pName = rs.getString("p_name");
				int price = rs.getInt("price");
				String mainImg = rs.getString("main_img");
				// 웹 페이지 줄바꿈 처리
				Product product = new Product();
				product.setCategoryName(categoryName);
				product.setpName(pName);
				product.setPrice(price);
				product.setMainImg(mainImg);
				resultList.add(product);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}

		return resultList;

	}

	@Override
	public int getCountAll(Connection connection, String categoryKey) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(*) cnt")
		  .append(" FROM product")
		  .append(" WHERE category_key = ?");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, categoryKey);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return count;
	}

	@Override
	public List<Category> findCategries(Connection connection) {
		List<Category> categoryList = null;

		// 기능 구현 시작
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT category_key, c_name")
		  .append(" FROM category");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			categoryList = new ArrayList<Category>();
			while (rs.next()) {
				String categoryKey = rs.getString("category_key");
				String categoryName = rs.getString("c_name");
				Category category = new Category(categoryKey, categoryName);
				categoryList.add(category);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null)		rs.close();
				if (pstmt != null)  pstmt.close();
			} catch (Exception e) {
			}
		}
		return categoryList;
	}
	
	@Override
	public Product findByName(Connection connection, String pName) {
		Product product = new Product();
		//기능 구현 시작
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT p.p_key pkey, p.p_name pname, p.price price, p.main_img mainimg, p.sub_img1 sub1, p.sub_img2 sub2, p.sub_img3 sub3, p.sub_img4 sub4, c.c_name cname")
		  .append(" FROM product p JOIN category c ON p.category_key = c.category_key")
		  .append(" WHERE p_name=?");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pKey = rs.getString("pkey");
				String productName = rs.getString("pname");
				int price = rs.getInt("price");
				String mainImg = rs.getString("mainimg");
				String subImg1 = rs.getString("sub1");
				String subImg2 = rs.getString("sub2");
				String subImg3 = rs.getString("sub3");
				String subImg4 = rs.getString("sub4");
				String categoryFullName = rs.getString("cname");
				
				product.setpKey(pKey);
				product.setpName(productName);
				product.setPrice(price);
				product.setMainImg(mainImg);
				product.setSubImg1(subImg1);
				product.setSubImg2(subImg2);
				product.setSubImg3(subImg3);
				product.setSubImg4(subImg4);
				product.setCategoryName(categoryFullName);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return product;
	}
}
