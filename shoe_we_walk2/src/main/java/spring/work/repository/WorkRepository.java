package spring.work.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class WorkRepository {
	private JdbcTemplate jdbcTemplate;

	public WorkRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Work> workRowMapper = 
			new RowMapper<Work>() {
				@Override
				public Work mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Work work = new Work(rs.getLong("user_id"),
							rs.getTimestamp("work_date").toLocalDateTime(),
							rs.getInt("step_num"),
							rs.getFloat("work_dist"),
							rs.getInt("calories")
							);
					return work;
				}
			};

	public void insert(WorkRegisterRequest work) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into work_table (user_id, work_date, step_num, work_dist, calories) " +
						"values (?, ?, ?, ?, ?)");
				// 인덱스 파라미터 값 설정
				pstmt.setLong(1, work.getUser_id());
				pstmt.setTimestamp(2, Timestamp.valueOf(work.getWork_date()));
				pstmt.setInt(3, work.getStep_num());
				pstmt.setFloat(4, work.getWork_dist());
				pstmt.setInt(5, work.getCalories());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}
	
	public List<Work> select(long user_id, String work_date1, String work_date2) {
		List<Work> results = jdbcTemplate.query(
				"select * from work_table where user_id = ? and work_date between ? and ?",
				workRowMapper, user_id, Timestamp.valueOf(work_date1), Timestamp.valueOf(work_date2));

		return results.isEmpty() ? null : results;
	}
	public List<Work> select(long user_id, LocalDateTime work_date1, LocalDateTime work_date2) {
		List<Work> results = jdbcTemplate.query(
				"select * from work_table where user_id = ? and work_date between ? and ?",
				workRowMapper, user_id, Timestamp.valueOf(work_date1), Timestamp.valueOf(work_date2));

		return results.isEmpty() ? null : results;
	}
}
