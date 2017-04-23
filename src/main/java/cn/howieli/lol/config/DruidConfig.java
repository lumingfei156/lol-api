package cn.howieli.lol.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfig {
	
	private Logger logger = LoggerFactory.getLogger(DruidConfig.class);
	
	@Value("${druid.url}")
	private String dbUrl;
	  
	@Value("${druid.username}")
	private String username;
	  
	@Value("${druid.password}")
	private String password;
	  
	@Value("${druid.driver-class-name}")
	private String driverClassName;
	  
	@Value("${druid.initialSize}")
	private int initialSize;
	  
	@Value("${druid.minIdle}")
	private int minIdle;
	  
	@Value("${druid.maxActive}")
	private int maxActive;
	  
	@Value("${druid.maxWait}")
	private int maxWait;
	  
	@Value("${druid.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	  
	@Value("${druid.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	  
	@Value("${druid.validationQuery}")
	private String validationQuery;
	  
	@Value("${druid.testWhileIdle}")
	private boolean testWhileIdle;
	  
	@Value("${druid.testOnBorrow}")
	private boolean testOnBorrow;
	  
	@Value("${druid.testOnReturn}")
	private boolean testOnReturn;
	  
	@Value("${druid.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	  
	@Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	  
	@Value("${druid.filters}")
	private String filters;
	  
	@Value("${druid.connectionProperties}")
	private String connectionProperties;
	
	@Value("${druid.maxOpenPreparedStatements}")
	private int maxOpenPreparedStatements;
	  
	@Bean
	@Primary  //Spring优先选择被该注解所标记的数据源
	public DataSource dataSource(){
	    DruidDataSource datasource = new DruidDataSource();

	    datasource.setUrl(this.dbUrl);
	    datasource.setUsername(username);
	    datasource.setPassword(password);
	    datasource.setDriverClassName(driverClassName);
	    datasource.setInitialSize(initialSize);
	    datasource.setMinIdle(minIdle);
	    datasource.setMaxActive(maxActive);
	    datasource.setMaxWait(maxWait);
	    datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	    datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	    datasource.setValidationQuery(validationQuery);
	    datasource.setTestWhileIdle(testWhileIdle);
	    datasource.setTestOnBorrow(testOnBorrow);
	    datasource.setTestOnReturn(testOnReturn);
	    datasource.setPoolPreparedStatements(poolPreparedStatements);
	    datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
	    datasource.setConnectionProperties(connectionProperties);
	    datasource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
	    
	    try {
	        datasource.setFilters(filters);
	    } catch (SQLException e) {
	        logger.error("druid configuration initialization filter", e);
	    }
	    datasource.setConnectionProperties(connectionProperties);
	    return datasource;
	}
	
}
