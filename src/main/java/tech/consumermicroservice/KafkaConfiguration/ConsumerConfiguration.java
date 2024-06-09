package tech.consumermicroservice.KafkaConfiguration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.HashMap;
import java.util.Map;


public class ConsumerConfiguration {

    public static Map<String, Object> consumerProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "GROUP-01");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        map.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        map.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 600000);
        return map;
    }
}
