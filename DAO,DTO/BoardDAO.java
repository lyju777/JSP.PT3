package com.koreait.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.koreait.db.Dbconn;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	
	public int write(BoardDTO board) {
		try {
			conn = Dbconn.getConnection();
			sql = "insert into tb_board(b_userid, b_title, b_content, b_file) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getB_userid());
			pstmt.setString(2, board.getB_title());
			pstmt.setString(3, board.getB_content());
			pstmt.setString(4, board.getB_file());
			if(pstmt.executeUpdate()>0) {
				return 1;
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

public BoardDTO edit(BoardDTO board) {
	try{
		conn = Dbconn.getConnection();
		if(conn != null){			
			sql = "select b_title, b_content ,b_file from tb_board where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getB_idx());
			rs = pstmt.executeQuery();
			if(rs.next()){
				board.setB_title(rs.getString("b_title"));  
				board.setB_content(rs.getString("b_content"));
				board.setB_file(rs.getString("b_file"));			
				return board;
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		}
		return null;
	}

public int editok(BoardDTO board) {
	try {
		conn = Dbconn.getConnection();
		if(conn != null){
			if(board.getB_file() != null && !board.getB_file().equals("")){
				
				sql = "update tb_board set b_title=?, b_content=?, b_file=? where b_idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getB_title());
				pstmt.setString(2, board.getB_content());
				pstmt.setString(3, board.getB_file());
				pstmt.setInt(4, board.getB_idx());
				
			}else{
				sql = "update tb_board set b_title=?, b_content=? where b_idx=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getB_title());
				pstmt.setString(2, board.getB_content());
				pstmt.setInt(3, board.getB_idx());
				
			}
			pstmt.executeUpdate();
			return 1;			}
	}catch(Exception e){
		e.printStackTrace();
	} 
	return 0;
	}

	public BoardDTO view(BoardDTO board) {
		try{
		      conn = Dbconn.getConnection();
		      if(conn != null){
		         sql = "update tb_board set b_hit = b_hit + 1 where b_idx=?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, board.getB_idx());
		         pstmt.executeUpdate();
		         
		         sql = "select b_idx, b_userid, b_title, b_content, b_regdate, b_like, b_hit, b_file from tb_board where b_idx=?";
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, board.getB_idx());
		         rs = pstmt.executeQuery();
		         
		         if(rs.next()){
		        	board.setB_userid(rs.getString("b_userid"));
		        	board.setB_title(rs.getString("b_title"));
		        	board.setB_content(rs.getString("b_content"));
		        	board.setB_regdate(rs.getString("b_regdate"));
		        	board.setB_like(rs.getInt("b_like"));
		        	board.setB_hit(rs.getInt("b_hit"));
		        	board.setB_file(rs.getString("b_file"));
		        	
		        	return board;
		         }
		      }
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		return null;
	}
}