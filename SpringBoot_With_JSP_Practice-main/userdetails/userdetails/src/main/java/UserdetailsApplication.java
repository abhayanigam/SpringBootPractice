import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.example.userdetails")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class UserdetailsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UserdetailsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserdetailsApplication.class, args);
		System.out.println("Hello");
	}

}
