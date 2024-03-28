package leaner.spring.cloud.aws.sqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.util.List;

@Service
public class AwsSqsPublisher {

    private SqsAsyncClient sqsAsyncClient;

    public AwsSqsPublisher(@Autowired SqsAsyncClient sqsAsyncClient) {
        this.sqsAsyncClient = sqsAsyncClient;
    }

    public void sendMessage(String Message){

    }
    public void sendBatchMessage(List<String> Messages){

    }


}
