package spring.item.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class ItemRepository {
	private JdbcTemplate jdbcTemplate;

	public ItemRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Item> itemRowMapper = 
			new RowMapper<Item>() {
				@Override
				public Item mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Item item = new Item(rs.getLong("user_id"),
							rs.getInt("item_id"),
							rs.getInt("item_cnt"), 
							rs.getInt("price"));
					return item;
				}
			};
	
	public void insert(Item item) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into item_table (user_id, item_id, item_cnt, price) " +
						"values (?, ?, ?, ?)");
				// 인덱스 파라미터 값 설정
				pstmt.setLong(1, item.getUser_id());
				pstmt.setInt(2, item.getItem_id());
				pstmt.setInt(3, item.getItem_cnt());
				pstmt.setInt(4, item.getPrice());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}
	
	public Item select(long user_id, int item_id) {
		List<Item> results = jdbcTemplate.query(
				"select * from item_table where user_id = ? and item_id = ?",
				itemRowMapper, user_id, item_id);

		return results.isEmpty() ? null : results.get(0);
	}

	public List<Item> select_all(long user_id) {
		List<Item> results = jdbcTemplate.query(
				"select * from item_table where user_id = ?",
				itemRowMapper, user_id);

		return results.isEmpty() ? null : results;
	}

	public void update(Item item) {
		jdbcTemplate.update(
				"update item_table set item_cnt = ? "
				+ "where user_id = ? and item_id = ?", 
				item.getItem_cnt(), item.getUser_id(), item.getItem_id());
	}
	 
}
