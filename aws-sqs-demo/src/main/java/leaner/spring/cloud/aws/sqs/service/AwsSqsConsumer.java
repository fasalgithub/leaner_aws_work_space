package leaner.spring.cloud.aws.sqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

@Service
public class AwsSqsConsumer {
    private SqsAsyncClient sqsAsyncClient;

    public AwsSqsConsumer(@Autowired SqsAsyncClient sqsAsyncClient) {
        this.sqsAsyncClient = sqsAsyncClient;
    }

    public void consumeMessage(){
    }

}
