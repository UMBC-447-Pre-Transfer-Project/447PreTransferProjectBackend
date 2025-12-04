package com.pretransfer.Pre_Transfer;
import com.pretransfer.Pre_Transfer.Classes.Staff;
import com.pretransfer.Pre_Transfer.Classes.Student;
import com.pretransfer.Pre_Transfer.Repository.StaffRepository;
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
                registry.addMapping("/auth/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
			}
		};
	}

    @Bean
    public CommandLineRunner run(StudentRepository repository, StaffRepository staffRepository) {
        return args -> {
            // Clean up existing data
            repository.deleteAll();

            // Save new users
            Student student = new Student();
            student.setId("123456");
            student.setFirstName("Jim");
            student.setLastName("Bob");
            student.setCurrentMajor("Computer Science");
            student.setCreditsCompleted(45);
            student.setIntendedMajor("Computer Science");
            repository.save(student);
            student.setId("123457");
            student.setFirstName("Tim");
            student.setLastName("Bab");
            student.setCurrentMajor("Mathematics");
            student.setCreditsCompleted(60);
            student.setIntendedMajor("Computer Science");
            repository.save(student);
            Staff staff = new Staff();
            staff.setId("1232");
            staff.setFirstName("Jim");
            staff.setLastName("Bob");
            staff.setEmail("fake@gmail.com");
            staff.setUsername("username");
            staff.setPassword("password");
            staffRepository.save(staff);
        };
    }
}
