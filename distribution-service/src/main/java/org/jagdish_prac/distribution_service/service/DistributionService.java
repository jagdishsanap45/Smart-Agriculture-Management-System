package org.jagdish_prac.distribution_service.service;

import org.jagdish_prac.distribution_service.configuration.KafkaProducer;
import org.jagdish_prac.distribution_service.entity.Distribution;
import org.jagdish_prac.distribution_service.repository.DistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionService {

    @Autowired
    private DistributionRepository distributionRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private EmailService emailService;

    @CacheEvict(value = "distributions", allEntries = true)
    public Distribution save(Distribution distribution){
        Distribution saved = distributionRepository.save(distribution);

        // Kafka
        String event = "Distributed " + saved.getItemName() + " to Farmer ID " + saved.getFarmerId();
        kafkaProducer.sendEvent(event);

        // Send Email
//        String to = saved.getFarmerEmail(); // make sure this field exists in entity
//        String subject = "New Distribution Assigned";
//        String body = "Hello Farmer,\n\nYou have a new distribution:\n" +
//                "Item: " + saved.getItemName() + "\n" +
//                "Date: " + saved.getDistributionDate() + "\n\nThank you!";


        String to = "jagdishsanap321@gmail.com"; // Use the address shown in your Mailtrap Inbox
        String subject = "Item Distributed";
        String body = "Item " + saved.getItemName() + " distributed to Farmer ID: " + saved.getFarmerId();
        emailService.sendMail(to, subject, body);


       // emailService.sendEmail(to, subject, body);

        return saved;
    }
    @Cacheable(value = "distributions")
    public List<Distribution> getAll(){
        System.out.println("Fetching from DB...");
        return distributionRepository.findAll();
    }
}
