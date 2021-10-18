package com.example.kafkaproducerstreams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class KafkaProducerStreamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerStreamsApplication.class, args);
    }

}
