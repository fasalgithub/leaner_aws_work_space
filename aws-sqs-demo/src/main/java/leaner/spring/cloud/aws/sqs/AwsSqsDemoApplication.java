package leaner.spring.cloud.aws.sqs;

import leaner.spring.cloud.aws.sqs.service.AwsSqsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSqsDemoApplication implements CommandLineRunner {
	@Autowired
	private AwsSqsAdmin awsSqsAdmin;

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Queue ");
		awsSqsAdmin.deleteQueue("sqs-learing-queue-test-new");
	}
}
