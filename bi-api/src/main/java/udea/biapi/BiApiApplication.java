package udea.biapi;

import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"udea.biapi"})
public class BiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiApiApplication.class, args);
	}
}
