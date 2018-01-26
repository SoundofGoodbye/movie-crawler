package moviecrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication(scanBasePackages = {"moviecrawler"})
@EnableScheduling
public class MovieCrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieCrawlerApplication.class, args);
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
        fact.setEntityManagerFactory(emf);
        return fact;
    }
}
