package org.jagdish_prac.officer_service.service;

import org.jagdish_prac.officer_service.entity.OfficerEvent;
import org.jagdish_prac.officer_service.repository.OfficerEventRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class KafkaConsumer {

    @Autowired
    private OfficerEventRepositry officerEventRepositry;


            @KafkaListener(topics = "distribution-events", groupId = "officer-group")
            public void listen(String message){
                OfficerEvent event = new OfficerEvent();
                event.setEventMessage(message);
                event.setReceivedDate(LocalDate.now().toString());

                officerEventRepositry.save(event);

                System.out.println(" Received Kafka event: " + message);
            }
}
