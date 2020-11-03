package green.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import green.util.DBConnectionPool;
import green.vo.Member;

public class MemberDao {
	DBConnectionPool connPool;

	
	public List<Member> selectlist() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = connPool.getConnection(); //Connection얻
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT MNO,MNAME,EMAIL,CRE_DATE" + " FROM MEMBERS" + " ORDER BY MNO ASC");
			ArrayList<Member> members = new ArrayList<Member>();

			while (rs.next()) {
				members.add(new Member().setNo(rs.getInt("MNO")).setName(rs.getString("MNAME"))
						.setEmail(rs.getString("EMAIL")).setCreatedDate(rs.getDate("CRE_DATE")));
			}
			return members;

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	public int insert(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = connPool.getConnection();
			stmt = connection
					.prepareStatement("insert into members(email, pwd, mname, cre_date, mod_date)  values(?, ?, ?, now(), now())");
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getName());
			return stmt.executeUpdate();
 // 의미가 없지만 일반 라이브러리가 데이터 추가 갯수를 반환하고 추가될 것이 없으면 0출
//			response.sendRedirect("list");	// 목록 보기로 이동함
		} catch (Exception e) {
			throw new ServletException();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			;
		}

	}

	public int update(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		// DB와 연결
		try {
		connection = connPool.getConnection();
			stmt = connection
					.prepareStatement("update members set email=?,mname=?,mod_date=now()" + " where mno =? ");

			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setInt(3, member.getNo());
			stmt.executeUpdate();
			return stmt.executeUpdate();
			//response.sendRedirect("list");

		} catch (Exception e) {
			throw new ServletException(); // 예외를 던짐
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			/*
			 * try {if (conn!=null) conn.close(); } catch(Exception e) {}
			 */
		}
		

	}
	public int delete (int no) throws Exception{
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = connPool.getConnection();
			stmt = connection
					.prepareStatement("delete from members where mno = " +no);
		}catch(Exception e) {
			throw e;
		}finally {
			try {if (stmt!=null) stmt.close();}catch(Exception e) {}
		}
		return 0;
	}

	public Member selectOne(int no) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = connPool.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select mno, email, mname, cre_date from members where mno="+ no);
			if(rs.next()) {
				return new Member().setEmail(rs.getString("email")).setName(rs.getString("mname"))
						.setNo(rs.getInt("mno")).setCreatedDate(rs.getDate("cre_date"));
			}else {
				throw new Exception("해당 번호를 찾을 수 없습니다.");
			}
		}catch(Exception e){
			throw e;
		}finally {
			try {if(rs!=null)rs.close();} catch(Exception e) {}
			try {if(stmt!=null)stmt.close();} catch(Exception e) {}
		}
		
	}
	public Member exist(String email, String password)throws Exception{
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = connPool.getConnection();
			stmt = connection.prepareStatement("select mname, email from members where email = ? and pwd = ?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Member().setName(rs.getString("mname"))
						.setEmail(rs.getString("email"));
				
			}else {
				return null;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			try {if(rs!= null)rs.close();}catch(Exception e) {}
			try {if(stmt!= null)stmt.close();}catch(Exception e) {}
			//다 사용하면 Connection 객체 반환, 이렇게 되면 DBConnectionPool에 추가
			if(connection !=null)connPool.returnConnection(connection);
		}
	}
}
