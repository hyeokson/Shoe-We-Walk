package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.UserDao;
import spring.WorkDao;
import spring.ItemDao;
import spring.ItemLocDao;
import spring.Service;

@Configuration
public class MemberConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://shoedb.c8g1muq7qhxz.ap-northeast-2.rds.amazonaws.com:3306/shoedb?characterEncoding=utf8&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("dnjfdk96");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}

	@Bean
	public UserDao userDao() {
		return new UserDao(dataSource());
	}
	
	@Bean
	public ItemDao itemDao() {
		return new ItemDao(dataSource());
	}
	
	@Bean
	public WorkDao workDao() {
		return new WorkDao(dataSource());
	}
	
	@Bean
	public ItemLocDao itemLocDao() {
		return new ItemLocDao(dataSource());
	}

	@Bean
	public Service service() {
		return new Service(userDao(), workDao(), itemDao(), itemLocDao());
	}

}
