package com.example.stats.service;

import com.example.stats.model.KafkaLog;
import com.example.stats.repository.KafkaLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class KafkaConsumerService {

    private final KafkaLogRepository repository;

    public KafkaConsumerService(KafkaLogRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "stats_topic", groupId = "stats-group")
    public void consume(String message) {
        KafkaLog log = new KafkaLog();
        log.setTopic("stats_topic");
        log.setContent(message);
        log.setTimestamp(LocalDateTime.now());
        repository.save(log);
        System.out.println("Saved to DB: " + message);
    }
}
