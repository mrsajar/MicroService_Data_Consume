package tech.consumermicroservice;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.consumermicroservice.ConsumerKafkaMessage.ConsumerTask;
import tech.consumermicroservice.KafkaConfiguration.ConsumerConfiguration;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ConsumerrmicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerrmicroserviceApplication.class, args);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // call kafka consumer task
        Consumer<String, String> consumer = new KafkaConsumer<>(ConsumerConfiguration.consumerProperties());
        consumer.subscribe(Collections.singletonList("hello-topic"));
        // submit task in thread poll
        ConsumerTask consumerTask = new ConsumerTask(consumer);
        executorService.submit(consumerTask);
        executorService.shutdown();

    }

}
