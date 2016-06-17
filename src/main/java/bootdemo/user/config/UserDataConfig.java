package bootdemo.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by trq on 2016/6/17.
 */
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"bootdemo.user.dao"}, entityManagerFactoryRef = "userEntityManagerFactory")
@EntityScan(basePackages = {"bootdemo.user.domain"})
@Configuration
public class UserDataConfig {

    @Bean
    public JpaVendorAdapter userJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }


    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.user.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "userEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(bookDataSource());
        emf.setJpaVendorAdapter(userJpaVendorAdapter());
        emf.setPackagesToScan("bootdemo.user.domain");
        emf.setPersistenceUnitName("default");   // <- giving 'default' as name
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean(name = "userEntityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }
}
