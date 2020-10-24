/**
 * @autor : Nelson Niño
 */

package co.com.nelsNio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PokemonBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonBackApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
