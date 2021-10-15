package com.example.kafkaproducerstreams.service;

import com.example.kafkaproducerstreams.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ObjectMapper mapper;

    private final KafkaTemplate<String, String> template;

    @Transactional
    public void sendMessage(Order order) {

        log.info("Send an order to consumers");

        String orderString = orderString(order);
        ProducerRecord<String, String> record = new ProducerRecord<>("ordering", orderString);
        template.send(record);
    }

    private String orderString(Order order) {
        try {
            return mapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
