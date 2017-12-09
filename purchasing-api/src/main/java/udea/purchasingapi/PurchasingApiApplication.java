package udea.purchasingapi;

import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"udea.purchasingapi"})
public class PurchasingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchasingApiApplication.class, args);
	}
}
