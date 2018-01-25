package moviecrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"moviecrawler"})
public class MovieCrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieCrawlerApplication.class, args);
    }
}
