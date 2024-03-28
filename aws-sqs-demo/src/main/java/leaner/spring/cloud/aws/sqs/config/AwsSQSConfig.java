package leaner.spring.cloud.aws.sqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class AwsSQSConfig {
    @Value("${spring.cloud.aws.credentials.access-key}")
    private String awsAccessKey;
    @Value("${spring.cloud.aws.credentials.secret-key}")
    private String awsSecurityKey;
    @Value("${spring.cloud.aws.region.static}")
    private String region;

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(awsAccessKey, awsSecurityKey)))
                .build();
    }

}
