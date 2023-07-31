package ezen.shoppingmall.domain.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ezen.shoppingmall.domain.customer.dto.Customer;

/**
 * RDB를 통해 고객 저장 및 관리(검색, 수정, 삭제) 구현체
 */
public class JdbcCustomerDao implements CustomerDao {
   
   /**
    * 신규회원 등록
    */
   public boolean create(Connection connection, Customer customer){
      boolean success = false;
      StringBuilder sb = new StringBuilder();
      sb.append(" INSERT INTO customer (")
        .append("     custKey,")
        .append("     email,")
        .append("     uName,")
        .append("     uPwd)")
        .append("     uBirth)")
        .append("     phoneNum)")
        .append(" VALUES (CUST_KEY_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
      
      PreparedStatement pstmt = null;
      try {
         pstmt = connection.prepareStatement(sb.toString());
         pstmt.setString(1, customer.getEmail());
         pstmt.setString(2, customer.getuName());
         pstmt.setString(3, customer.getuPwd());
         pstmt.setString(4, customer.getuBirth());
         pstmt.setString(5, customer.getPhoneNum());
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
   
   public Customer findByUser(Connection connection, String email, String uPwd) {
      Customer customer = null;
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT email, cust_key, u_name, phone_num")
      	.append(" FROM customer")
        .append(" WHERE email = ? AND u_pwd = ?");
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = connection.prepareStatement(sb.toString());
         pstmt.setString(1, email);
         pstmt.setString(2, uPwd);
         rs = pstmt.executeQuery();

         if (rs.next()) {         
            String uemail = rs.getString("email");
            int custKey = rs.getInt("cust_key");
            String uname = rs.getString("u_name");
            String phoneNum = rs.getString("phone_num");
            customer = new Customer();
            customer.setEmail(uemail);
            customer.setCustKey(custKey);
            customer.setuName(uname);
            customer.setPhoneNum(phoneNum);
         }
         
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      } finally {
         try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
         } catch (Exception e) {}
      }
      return customer;
   }
   
   @Override
   public List<Customer> findByAll(Connection connection) {
      List<Customer>  list = null;
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT FROM customer");
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = connection.prepareStatement(sb.toString());
         rs = pstmt.executeQuery();
         list = new ArrayList<Customer>();
         while (rs.next()) {         
            String uemail = rs.getString("email");
            String uname = rs.getString("uName");
            String phonenum = rs.getString("phoneNum");
            Customer customer = new Customer();
            customer.setEmail(uemail);
            customer.setuName(uname);
            customer.setPhoneNum(phonenum);
            list.add(customer);
         }
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      } finally {
         try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
         } catch (Exception e) {}
      }
      return list;
   }
   
   @Override
   public Customer findByEmail(Connection connection, String email) {
      Customer customer = null;
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT cust_key, u_name, email")
        .append(" FROM customer")
        .append(" WHERE email = ?");
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = connection.prepareStatement(sb.toString());
         pstmt.setString(1, email);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            customer = new Customer();
            int custKey = rs.getInt("cust_key");
            String uemail = rs.getString("email");
            String uname = rs.getString("u_name");
            customer.setCustKey(custKey);
            customer.setEmail(uemail);
            customer.setuName(uname);
         }
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      } finally {
         try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
         } catch (Exception e) {}
      }
      return customer;
   }
   
   
   public static void main(String[] args) throws Exception {
      
//      Member member = new Member("heeyoung", "1111", "이희영", "heeyoung@gmail.com", null);
//      MemberDao dao = DaoFactory.getInstance().getMemberDao();
//      dao.create(member);
//      System.out.println("등록 완료");
      
//      Member loginMember = dao.findByUser("bangry313", "1111");
//      System.out.println(loginMember);
//      System.out.println(dao.findById("angry"));
      
   }


   
}
