package com.pretransfer.Pre_Transfer;
import com.pretransfer.Pre_Transfer.Classes.Student;
import com.pretransfer.Pre_Transfer.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class PreTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreTransferApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:5173")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}

    @Bean
    public CommandLineRunner run(StudentRepository repository) {
        return args -> {
            // Clean up existing data
            repository.deleteAll();

            // Save new users
            Student student = new Student();
            student.setStudentId("123456");
            student.setFirstName("Jim");
            student.setLastName("Bob");
            student.setMajor("Computer Science");
            student.setCreditsCompleted(45);
            student.setStatus("Committed");
            repository.save(student);
            student.setStudentId("123457");
            student.setFirstName("Tim");
            student.setLastName("Bab");
            student.setMajor("Mathematics");
            student.setCreditsCompleted(60);
            student.setStatus("Not Committed");
            repository.save(student);
        };
    }
}
