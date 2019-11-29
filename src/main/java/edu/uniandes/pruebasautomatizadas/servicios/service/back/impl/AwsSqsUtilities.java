package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.HashMap;
import java.util.Map;

public class AwsSqsUtilities {

    private static AWSCredentials credentials;

    private static final String cola = System.getenv("SQS_QUEUE_URL");

    public AwsSqsUtilities(){
        credentials = new BasicAWSCredentials(
                System.getenv("AWS_ACCESS_KEY_UA"),
                System.getenv("AWS_SECRET_KEY_UA")
        );
    }

    public void sendSQSMessage(Map<String, String> messageAttributes, String body){

        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

        Map<String, MessageAttributeValue> attributes = configureMessageAttributes(messageAttributes);

        SendMessageRequest sendMessageStandardQueue = new SendMessageRequest().withQueueUrl(cola)
                .withMessageBody(body)
                .withMessageAttributes(attributes);

        sqs.sendMessage(sendMessageStandardQueue);


        /*
        // Delete a message from a queue

        sqs.deleteMessage(new DeleteMessageRequest().withQueueUrl(fifoQueueUrl)
            .withReceiptHandle(sqsMessages.get(0)
                .getReceiptHandle()));

        // Monitoring
        GetQueueAttributesRequest getQueueAttributesRequest = new GetQueueAttributesRequest(standardQueueUrl).withAttributeNames("All");
        GetQueueAttributesResult getQueueAttributesResult = sqs.getQueueAttributes(getQueueAttributesRequest);
        System.out.println(String.format("The number of messages on the queue: %s", getQueueAttributesResult.getAttributes()
            .get("ApproximateNumberOfMessages")));
        System.out.println(String.format("The number of messages in flight: %s", getQueueAttributesResult.getAttributes()
            .get("ApproximateNumberOfMessagesNotVisible")));

        */
    }

    private Map<String, MessageAttributeValue> configureMessageAttributes(Map<String, String> attributes){

        Map<String, MessageAttributeValue> params = new HashMap<>();
        attributes.forEach((k,v) -> {
            params.put(k, new MessageAttributeValue().withStringValue(v).withDataType("String"));
        });
        return params;
    }

    /*
    public static void main(String[] args) {
        AwsSqsUtilities awsSqsUtilities = new AwsSqsUtilities();
        Map<String, String> params = new HashMap<>();
        params.put("attr_1", "valor 1");
        params.put("attr_2", "valor 2");
        params.put("attr_3", "valor 3");
        params.put("attr_4", "valor 4");

        String cuerpo = "cuerpo del mensaje";
        awsSqsUtilities.sendSQSMessage(params, cuerpo);
    }
    */

}
