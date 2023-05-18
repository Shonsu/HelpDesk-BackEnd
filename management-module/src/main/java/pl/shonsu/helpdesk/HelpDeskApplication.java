package pl.shonsu.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("pl.shonsu")
@EntityScan("pl.shonsu")
@SpringBootApplication(scanBasePackages = {"pl.shonsu.security","pl.shonsu.user", "pl.shonsu.helpdesk", "pl.shonsu.userhelpdesk"})
public class HelpDeskApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelpDeskApplication.class, args);
    }
}
