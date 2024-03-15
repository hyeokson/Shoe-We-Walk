package spring.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class UserRepository {

	private final JdbcTemplate jdbcTemplate;

	public UserRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<User> userRowMapper = 
			new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			User user = new User(rs.getLong("user_id"),
					rs.getString("user_name"),
					rs.getString("gender"),
					rs.getInt("age"),
					rs.getInt("height"),
					rs.getDouble("weight"),
					rs.getInt("total_item"),
					rs.getInt("balance"));
			return user;
		}
	};
	
	public void insert(User user) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into user_table (user_id, user_name, gender, age, height, weight, total_item, balance) " +
						"values (?, ?, ?, ?, ?, ?, ?, ?)");
				// 인덱스 파라미터 값 설정
				pstmt.setLong(1, user.getUser_id());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getGender());
				pstmt.setInt(4, user.getAge());
				pstmt.setInt(5, user.getHeight());
				pstmt.setDouble(6, user.getWeight());
				pstmt.setInt(7, user.getTotal_item());
				pstmt.setInt(8, user.getBalance());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}
	
	public User select(long user_id) {
		List<User> results = jdbcTemplate.query(
				"select * from user_table where user_id = ?",
				userRowMapper, user_id);

		return results.isEmpty() ? null : results.get(0);
	}

	

	public void update(User user) {
		jdbcTemplate.update(
				"update user_table set user_name = ?"
				+ ", gender = ?, age = ?, height = ?, weight = ?, total_item =?, balance =? where user_id = ?",
				user.getName(), user.getGender(), user.getAge(),
				user.getHeight(), user.getWeight(), user.getTotal_item(), user.getBalance(), user.getUser_id());
	}
	

}
