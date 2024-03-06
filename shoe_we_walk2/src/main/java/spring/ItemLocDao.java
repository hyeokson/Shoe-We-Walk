package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class ItemLocDao {
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<ItemLoc> itemRowMapper = 
			new RowMapper<ItemLoc>() {
				@Override
				public ItemLoc mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					ItemLoc itemloc = new ItemLoc(rs.getLong("user_id"),
							rs.getInt("loc_1"),
							rs.getInt("loc_2"),
							rs.getInt("loc_3"),
							rs.getInt("loc_4"),
							rs.getInt("loc_5"),
							rs.getInt("loc_6"),
							rs.getInt("loc_7"),
							rs.getInt("loc_8"),
							rs.getInt("loc_9"),
							rs.getInt("loc_10"));
					return itemloc;
				}
			};
			
	public ItemLocDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(ItemLoc itemloc) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into itemloc_table (user_id, loc_1, loc_2, loc_3,"
						+ "loc_4, loc_5, loc_6, loc_7, loc_8, loc_9, loc_10) " +
						"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				// 인덱스 파라미터 값 설정
				pstmt.setLong(1, itemloc.getUser_id());
				pstmt.setInt(2, itemloc.getLoc_1());
				pstmt.setInt(3, itemloc.getLoc_2());
				pstmt.setInt(4, itemloc.getLoc_3());
				pstmt.setInt(5, itemloc.getLoc_4());
				pstmt.setInt(6, itemloc.getLoc_5());
				pstmt.setInt(7, itemloc.getLoc_6());
				pstmt.setInt(8, itemloc.getLoc_7());
				pstmt.setInt(9, itemloc.getLoc_8());
				pstmt.setInt(10, itemloc.getLoc_9());
				pstmt.setInt(11, itemloc.getLoc_10());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}
	
	public ItemLoc select(long user_id) {
		List<ItemLoc> results = jdbcTemplate.query(
				"select * from itemloc_table where user_id = ?",
				itemRowMapper, user_id);

		return results.isEmpty() ? null : results.get(0);
	}


	public void update(ItemLocRegisterRequest itemloc) {
		jdbcTemplate.update(
				"update itemloc_table set loc_1 = ? , loc_2 = ?, loc_3 = ?, loc_4 = ?, loc_5 = ?"
				+ ", loc_6 = ?, loc_7 = ?, loc_8 = ?, loc_9 = ?, loc_10 = ? "
				+ "where user_id = ?", 
				itemloc.getLoc_1(), itemloc.getLoc_2(), itemloc.getLoc_3(), itemloc.getLoc_4(), itemloc.getLoc_5(),
				itemloc.getLoc_6(), itemloc.getLoc_7(), itemloc.getLoc_8(), itemloc.getLoc_9(), itemloc.getLoc_10(),
				itemloc.getUser_id());
	}
}
