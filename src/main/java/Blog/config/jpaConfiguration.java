package Blog.config;

import ch.qos.logback.core.db.DataSourceConnectionSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.LocalEntityManagerFactoryBean

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class jpaConfiguration
{
    @Bean
    public EntityManagerFactory entityManagerFactoryy()
    {
        LocalContainerEntityManagerFactoryBean l=new LocalContainerEntityManagerFactoryBean();
        l.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        l.afterPropertiesSet();
        return l.getObject();
    }
    @Bean
    public DataSource datasource()
    {

        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5433/post");
        ds.setUsername("postgres");
        ds.setPassword("9463690786");
        return ds;
    }

}