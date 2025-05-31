package org.jagdish_prac.distribution_service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    private static final String TOPIC = "distribution-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(String message){
        kafkaTemplate.send(TOPIC, message);
    }
}
