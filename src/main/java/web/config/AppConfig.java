package web.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "web")
public class AppConfig {

   @Autowired
   private Environment env;


   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(getDataSource());
      em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));
      em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      em.setJpaProperties(getHibernateProperties());

      return em;
   }

   @Bean
   public PlatformTransactionManager platformTransactionManager() {
      JpaTransactionManager manager = new JpaTransactionManager();
      manager.setEntityManagerFactory(entityManagerFactory().getObject());
      return manager;
   }


   @Bean
   public DataSource getDataSource() {
      BasicDataSource ds = new BasicDataSource();
      ds.setDriverClassName(env.getRequiredProperty("db.driver"));
      ds.setUrl(env.getRequiredProperty("db.url"));
      ds.setUsername(env.getRequiredProperty("db.username"));
      ds.setPassword(env.getRequiredProperty("db.password"));

      return ds;
   }
   @Bean
   public Properties getHibernateProperties() {
      Properties properties = new Properties();
      try(InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties")) {
         properties.load(is);
         return properties;
      } catch (IOException e) {
         throw new IllegalArgumentException("cannot find hibernate.properties ", e);
      }
   }
}
