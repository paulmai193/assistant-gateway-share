package logia.assistant.share.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * The Class AssistantGatewayShareApplication.
 *
 * @author Dai Mai
 */
@Configuration
@ComponentScan(basePackages = {"logia.assistant.share.gateway"})
@PropertySource("classpath:application.properties")
public class AssistantGatewayShareApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AssistantGatewayShareApplication.class, args);
	}
}
