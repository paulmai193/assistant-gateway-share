package logia.assistant.share.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"logia.assistant.share.gateway"})
@PropertySource("classpath:application.properties")
public class AssistantGatewayShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistantGatewayShareApplication.class, args);
	}
}
