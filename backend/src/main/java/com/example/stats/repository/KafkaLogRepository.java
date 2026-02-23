package com.example.stats.repository;

import com.example.stats.model.KafkaLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaLogRepository extends JpaRepository<KafkaLog, Long> {
}
