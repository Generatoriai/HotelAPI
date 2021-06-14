package lt.viko.eif.generatoriai.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class.
 * @version 1.0
 * @since 1.0
 * @author Arminas M. Denis M. Goda M. Lukas A. Deividas K.
 */
@SpringBootApplication
@EnableSwagger2
public class HotelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApiApplication.class, args);
	}

}
