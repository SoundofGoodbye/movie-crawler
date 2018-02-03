package moviecrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;



@SpringBootApplication(scanBasePackages = {"moviecrawler"})
@EnableScheduling
public class MovieCrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieCrawlerApplication.class, args);
    }

    @Bean
    TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }
}
