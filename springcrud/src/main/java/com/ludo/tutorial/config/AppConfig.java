package com.ludo.tutorial.config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ludo.tutorial.model.Book;

@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();
		// Setting JDBC properties
		props.put(DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(URL, "jdbc:mysql://localhost:3306/form_springcrud");
		props.put(USER, "root");
		props.put(PASS, "");

		// Setting Hibernate properties
		props.put(SHOW_SQL, true);
		props.put(HBM2DDL_AUTO, "update");

		// Setting C3P0 properties
		props.put(C3P0_MIN_SIZE, 5);
		props.put(C3P0_MAX_SIZE, 20);
		props.put(C3P0_ACQUIRE_INCREMENT, 5);
		props.put(C3P0_TIMEOUT, 1800);
		props.put(C3P0_MAX_STATEMENTS, 150);

		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses(new Class[] { Book.class });
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
