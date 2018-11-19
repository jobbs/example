/**
 * copyright 2016 NCIS Cloud Portal System
 * @description
 * <pre></pre>
 *
 * @filename SlaveDatabaseConfig.java
 *
 * @author 최진호
 * @lastmodifier 최진호
 * @created 2016. 10. 4.
 * @lastmodified 2016. 10. 4.
 *
 * @history
 * -----------------------------------------------------------
 * Date         author         ver            Description
 * -----------------------------------------------------------
 * 2016. 10. 4.     최진호         v1.0             최초생성
 *
 */
package ncis.cmn.webconfig;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
/*
 * Spring 프레임워크의 어노 테이션 기반 트랜잭션 관리를 사용할 수 있도록 한다.
 * <tx:annotation-driven>
 */
//@EnableTransactionManagement
public class SlaveDatabaseConfig {

	@Autowired
    ApplicationContext applicationContext;


	/**
	 * DataSource 설정
	 *
	 * @return
	 */
	@Bean(name="slaveDataSource")
	public DataSource slaveDataSource() {

//	    JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//	    dsLookup.setResourceRef(true);
//	    DataSource dataSource = dsLookup.getDataSource("java:jboss/nciaDmDS");

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://10.180.213.177:5432/ncia_dm");
		dataSource.setUrl("jdbc:postgresql://10.0.4.88:5432/ncia_dm");
//		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//		dataSource.setUrl("jdbc:log4jdbc:postgresql://10.180.213.177:5432/ncia_dm");

		dataSource.setUsername("postgres");
        dataSource.setPassword("pgsql123#");

		return dataSource;
	}

//	/**
//	 * TransactionManager설정
//	 *
//	 * @return
//	 */
//	@Bean(name="slaveTransactionManager")
//	public PlatformTransactionManager slaveTransactionManager() {
//		return new DataSourceTransactionManager(slaveDataSource());
//	}

	/**
	 * SqlSessionFactory 설정
	 *
	 * @param dataSource
	 * @param applicationContext
	 * @return
	 * @throws IOException
	 */
	@Bean(name="slaveSqlSessionFactoryBean")
	public SqlSessionFactoryBean slaveSqlSessionFactoryBean(@Qualifier("slaveDataSource") DataSource dataSource,
			ApplicationContext applicationContext) throws IOException {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/configuration.xml"));
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mappers/**/*.xml"));

		return factoryBean;
	}

	/**
	 * SqlSessionTemplate 설정
	 *
	 * @param sqlSessionFactory
	 * @return
	 */
	 @Bean(name="slaveSqlSession")
	 public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaveSqlSessionFactoryBean") SqlSessionFactory sqlSessionFactory) {
	     return new SqlSessionTemplate(sqlSessionFactory);
	 }

}
