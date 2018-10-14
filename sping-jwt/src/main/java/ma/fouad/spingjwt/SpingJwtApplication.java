package ma.fouad.spingjwt;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.fouad.spingjwt.entities.AppRole;
import ma.fouad.spingjwt.service.AccountService;

@SpringBootApplication
public class SpingJwtApplication  implements CommandLineRunner{
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(SpingJwtApplication.class, args);
		
	

	}
	

	@Override
	public void run(String... args) throws Exception {
		
		Stream.of("ADMIN","USER").forEach(r->{
			
			accountService.saveRole(new AppRole(null,r));
		});


		
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {

		return new BCryptPasswordEncoder();
	}

	
}
