package bootdemo.book.config;

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
@EnableJpaRepositories(basePackages = {"bootdemo.book.dao"}, entityManagerFactoryRef = "bookEntityManagerFactory")
@EntityScan(basePackages = {"bootdemo.book.domain"})
@Configuration
public class BookDataConfig {
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean(name = "bookDataSource")
    @ConfigurationProperties(prefix = "spring.book.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "bookEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(bookDataSource());
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("bootdemo.book.domain");
        emf.setPersistenceUnitName("default");   // <- giving 'default' as name
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean(name = "bookEntityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }
}
