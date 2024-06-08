package tech.consumermicroservice.ConsumerKafkaMessage;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;

public class ConsumerTask implements Runnable {

    private final Consumer<String, String> consumer;

    public ConsumerTask(Consumer<String, String> consumer) {
        this.consumer = consumer;
    }


    @Override
    public void run() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            records.forEach(record ->{
                System.out.println("receive message from kafka " + record.value());
            });
        }
    }
}
