package test.web.model;

import java.sql.*;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;

public class BoardDao {	
	private static BoardDao instance;

	private BoardDao() {};

	// 싱글톤 패턴
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int cnt;
	private ArrayList<BoardDto> list;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	String SQL_SELECTALL = "SELECT * FROM BOARD ORDER BY NUM DESC";
	String SQL_SELECTONE = "SELECT * FROM BOARD WHERE NUM=?";
	String SQL_SELECT = "SELECT * FROM SARAM WHERE TITLE LIKE '%' || ? || '%'";
	// insert = author, email, title, content, passwd
	String SQL_INSERT = "INSERT INTO BOARD VALUES(seq_board.nextval,?,?,?,?,?,sysdate,0,0,0,0);";
	String SQL_DELETE = "DELETE FROM BOARD WHERE NUM=?";
	String SQL_UPDATE = "UPDATE BOARD SET AUTHOR=?, EMAIL=?, TITLE=?, CONTENT=?, PASSWD=? WHERE NUM=?";

	public ArrayList<BoardDto> list() {
		list = new ArrayList<BoardDto>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECTALL);
			while (rs.next()) {
				// 새 내용 추가
				int num =  rs.getInt("num");
				String author = rs.getString("author");
				String email = rs.getString("email");
				String title = rs.getString("title");
				Timestamp writeday = rs.getTimestamp("writeday");
				BoardDto data = new BoardDto(num, author, email, title, null, null, writeday, 0, 0, 0, 0);
				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return list;
	}

	public ArrayList<BoardDto> selectOne(BoardDto dto) {
		list = new ArrayList<BoardDto>();
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECTONE);
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto dto3 = new BoardDto();
				dto3.setNum(rs.getInt(1));
				dto3.setAuthor(rs.getString(2));
				dto3.setEmail(rs.getString(3));
				dto3.setTitle(rs.getString(4));
				dto3.setContent(rs.getString(5));
				list.add(dto3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}
		return list;
	}
//
//	public ArrayList<BoardDto> select(BoardDto dto) {
//		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
//		try {
//			pstmt = conn.prepareStatement(SQL_SELECT);
//			pstmt.setString(1, dto.getName());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(rs, pstmt, null);
//		}
//		return list;
//	}

	public void insert(BoardDto dto) {
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT);
			// 여기에 새 내용 추가
			pstmt.setString(1, dto.getAuthor());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getPasswd());
			
			cnt = pstmt.executeUpdate();
			if (cnt <= 0) {
				System.out.println("INSERT ERROR : Rollback");
				conn.rollback();
			} else {
				System.out.println("INSERT SUCCESS : Commit");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
	}

	public void delete(BoardDto dto) {
//		String SQL_DELETE = "DELETE FROM BOARD WHERE TITLE=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, dto.getNum());
			cnt = pstmt.executeUpdate();
			if (cnt <= 0) {
				System.out.println("DELETE ERROR : Rollback");
				conn.rollback();
			} else {
				System.out.println("DELETE SUCCESS : Commit");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, conn);
		}
	}

	public void update(BoardDto dto) {
//		String SQL_UPDATE = "UPDATE BOARD SET AUTHOR=?, EMAIL=?, TITLE=?, CONTENT=?, PASSWD=? WHERE NUM=?";
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, dto.getAuthor());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getPasswd());
			cnt = pstmt.executeUpdate();
			if (cnt <= 0) {
				System.out.println("UPDATE ERROR : Rollback");
				conn.rollback();
			} else {
				System.out.println("UPDATE SUCCESS : Commit");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, conn);
		}
	}

	// TDD - 테스트 주도 개발 (단위 별로 메인을 만들어서 실행해보자) => JUnit
	public static void test_selectAll() {

	}

	public static void test_insert(BoardDto dto) {

	}
}