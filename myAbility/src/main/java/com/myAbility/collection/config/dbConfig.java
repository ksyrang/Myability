package com.myAbility.collection.config;

import java.io.IOException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = 
	{
		"com.myAbility.collection.login.DAO",
		"com.myAbility.collection.member.DAO"
	}
)
public class dbConfig {
		
	@Bean
	public HikariDataSource dataSource() {
		HikariConfig hkConfig = new HikariConfig();
		hkConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hkConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkConfig.setUsername("myability");
		hkConfig.setPassword("myability1");
		
		HikariDataSource dataSource = new HikariDataSource(hkConfig);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean ssFactory = new SqlSessionFactoryBean();
		ssFactory.setDataSource(dataSource());
		
		PathMatchingResourcePatternResolver resovler = new PathMatchingResourcePatternResolver();
		ssFactory.setMapperLocations(resovler.getResources("/mappers/**/*Mapper.xml"));
		
		return ssFactory;		
	}
}
