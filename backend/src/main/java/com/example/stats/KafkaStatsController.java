package com.example.stats;

import org.springframework.web.bind.annotation.CrossOrigin; // <--- ADD THIS
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "*") // <--- ADD THIS MAGIC LINE
public class KafkaStatsController {
    // ... rest of your code
}
