package ezen.shoppingmall.domain.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ezen.shoppingmall.domain.cart.dto.Cart;
import ezen.shoppingmall.domain.cart_item.dto.CartItem;
import ezen.shoppingmall.domain.product.dto.Product;

/**
 * CartDao를 구현한 구현체
 * 
 * @author 조영호
 *
 */
public class JdbcCartDao implements CartDao {
	
	/**
	 * 해당회원의 카트아이템 정보를 받아와 카트에 담아 반환하는 메소드
	 */
	@Override
	public Cart getCart(Connection connection, int custKey) {
		Cart cart;
		CartItem cartItem = null;
		Product product = null;
		List<CartItem> cartItems = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT")
		  .append("      p.p_key pkey,")
		  .append("      p.p_name pname,")
		  .append("      p.price price,")
		  .append("      p.main_img img,")
		  .append("      ci.p_cnt count,")
		  .append("      ci.contain_date containday,")
		  .append("      cat.c_name cname,")
		  .append("      (")
		  .append("       SELECT SUM(SUM(p.price * ci.p_cnt))")
		  .append("       FROM  cart_item ci")
		  .append("       JOIN product p ON ci.p_key = p.p_key")
		  .append("       JOIN cart c ON ci.cart_key = c.cart_key")
		  .append("       WHERE c.cust_key = ?")
		  .append("       GROUP BY")
		  .append("       p.p_name,")
		  .append("       p.price,")
		  .append("       p.main_img,")
		  .append("       ci.p_cnt,")
		  .append("       ci.contain_date")
		  .append("      ) totalPrice")
		  .append(" FROM")
		  .append("      cart_item ci")
		  .append("      JOIN product p ON ci.p_key = p.p_key")
		  .append("      JOIN cart c ON ci.cart_key = c.cart_key")
		  .append("      JOIN category cat ON p.category_key = cat.category_key")
		  .append(" WHERE")
		  .append("      c.cust_key = ?");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setInt(1, custKey);
			pstmt.setInt(2, custKey);
			rs = pstmt.executeQuery();
			cartItems = new ArrayList<CartItem>();
			int totalPay = 0;
			while (rs.next()) {
				String pKey = rs.getString("pkey");
				String pName = rs.getString("pname");
				int price = rs.getInt("price");
				String mainImg = rs.getString("img");
				int count = rs.getInt("count");
				String containDate = rs.getString("containday");
				String categoryName = rs.getString("cname");
				totalPay = rs.getInt("totalPrice");
				// Cart에 담을 항목 setter초기화 후 담아 리스트완성
				product = new Product();
				product.setpKey(pKey);
				product.setpName(pName);
				product.setPrice(price);
				product.setMainImg(mainImg);
				product.setCategoryName(categoryName);

				cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setProductCnt(count);
				cartItem.setContainDate(containDate);

				cartItems.add(cartItem);
			}
			cart = new Cart(cartItems,totalPay);
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
		return cart;
	}
	
	/**
	 * 회원이 생성됨과 동시에 카트를 그 회원 전용으로 하나 생성하기 위한 카트 생성메소드
	 */
	@Override
	public boolean giveCart(Connection connection, int custKey) {
		boolean success = false;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO cart (")
		  .append("    cart_key,")
		  .append("    cust_key")
		  .append(" ) VALUES (")
		  .append("     cart_key_seq.NEXTVAL,")
		  .append("     ?")
		  .append(" )");

		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setInt(1, custKey);
			pstmt.executeUpdate();
			success = true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return success;
	}
	
	/**
	 * 장바구니 추가 버튼을 누르면 실제로 테이블에 상품이 추가되는 메소드
	 */
	@Override
	public boolean addToCart(Connection connection, int cartNum, String pName) {
		boolean success = false;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO cart_item (")
		  .append("    cart_item_key,")
		  .append("    cart_key,")
		  .append("    p_key")
		  .append(" ) VALUES (")
		  .append("     cart_item_key_seq.NEXTVAL,")
		  .append("     ?,")
		  .append("     ?")
		  .append(" )");

		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setInt(1, cartNum);
			pstmt.setString(2, pName);
			pstmt.executeUpdate();
			success = true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return success;
	}
	
	/**
	 * 버튼이 눌릴 때 마다 실제로 데이터가 바뀌는 메소드
	 */
	@Override
	public boolean updateCount(Connection connection, int count, int cartNum, String p_key) {
		boolean success = false;
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE cart_item")
		  .append(" SET")
		  .append("   p_cnt = ?")
		  .append(" WHERE")
		  .append("   cart_key = ? AND p_key = ?");

		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setInt(1, count);
			pstmt.setInt(2, cartNum);
			pstmt.setString(3, p_key);
			pstmt.executeUpdate();
			success = true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return success;
	}

}
