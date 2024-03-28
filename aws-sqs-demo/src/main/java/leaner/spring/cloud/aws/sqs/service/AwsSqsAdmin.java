package leaner.spring.cloud.aws.sqs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.concurrent.ExecutionException;

@Service
public class AwsSqsAdmin {
    private SqsAsyncClient sqsAsyncClient;

    public AwsSqsAdmin(@Autowired SqsAsyncClient sqsAsyncClient) {
        this.sqsAsyncClient = sqsAsyncClient;
    }

    public void getAllQueues() throws ExecutionException, InterruptedException {
        sqsAsyncClient.listQueues().get().queueUrls().forEach(System.out::println);
    }

    public String getQueueUrlByQueueName(String queueName) throws ExecutionException, InterruptedException {
        String queueUrl = sqsAsyncClient.getQueueUrl(GetQueueUrlRequest.builder()
                .queueName(queueName).build()).get().queueUrl();
        System.out.println(queueUrl);
        return queueUrl;
    }

    public void createNewQueue(String queueName) throws ExecutionException, InterruptedException {
        String newQueueUrl = sqsAsyncClient.createQueue(CreateQueueRequest.builder().queueName(queueName).build())
                .get().queueUrl();
        System.out.println("newQueueUrl :" + newQueueUrl);
    }

    public void deleteQueue(String queueName) throws ExecutionException, InterruptedException {
        String queueUrl = this.getQueueUrlByQueueName(queueName);
        System.out.println("queueUrl " + queueUrl);
        boolean isSuccess = sqsAsyncClient
                .deleteQueue(DeleteQueueRequest.builder().queueUrl(queueUrl).build())
                .get().sdkHttpResponse().isSuccessful();
        System.out.println("Queue Deleted Status " + isSuccess);


    }
    public void purgeQueue(String queueName) throws ExecutionException, InterruptedException {
        String queueUrl = this.getQueueUrlByQueueName(queueName);
        System.out.println("queueUrl " + queueUrl);
        boolean isSuccess = sqsAsyncClient.purgeQueue(PurgeQueueRequest.builder().queueUrl(queueUrl).build()).get().sdkHttpResponse().isSuccessful();
        System.out.println("Queue Purged Status " + isSuccess);
    }

    public void deleteMessageFromQueue(String queueName,String message) throws ExecutionException, InterruptedException {
        String queueUrl = this.getQueueUrlByQueueName(queueName);
        System.out.println("queueUrl " + queueUrl);
        boolean isSuccess =sqsAsyncClient.deleteMessage(DeleteMessageRequest.builder().queueUrl(queueUrl).receiptHandle(message).build()).get().sdkHttpResponse().isSuccessful();
        System.out.println("Message Deleted Status " + isSuccess);
    }

}


