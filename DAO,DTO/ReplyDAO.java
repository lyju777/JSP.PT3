package com.koreait.member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.koreait.db.Dbconn;
public class ReplyDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	
	
	public ReplyDTO reply (ReplyDTO reply, BoardDTO board) {
		try {
			conn = Dbconn.getConnection();
			if(conn != null){			
			sql = "select re_idx, re_userid, re_content, re_regdate from tb_reply where re_boardidx=? order by re_idx desc";
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setInt(1, board.getB_idx());
			   rs = pstmt.executeQuery();
			   
			   while(rs.next()){
				  reply.setRe_idx(rs.getInt("re_idx")); 
			      reply.setRe_userid(rs.getString("re_userid"));
			      reply.setRe_content(rs.getString("re_content"));
			      reply.setRe_regdate(rs.getString("re_regdate"));
			   }
			}return reply;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}