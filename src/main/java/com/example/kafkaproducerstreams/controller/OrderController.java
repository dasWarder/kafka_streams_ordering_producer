package com.example.kafkaproducerstreams.controller;

import com.example.kafkaproducerstreams.dto.OrderRequest;
import com.example.kafkaproducerstreams.dto.Status;
import com.example.kafkaproducerstreams.map.OrderMapper;
import com.example.kafkaproducerstreams.model.Order;
import com.example.kafkaproducerstreams.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/producer/order")
public class OrderController {

  private final OrderMapper mapper;

  private final OrderService service;

  @PostMapping
  public ResponseEntity<Status> sendMessage(@RequestBody OrderRequest request) {

    Order order = mapper.orderRequestToOrder(request);
    service.sendMessage(order);
    Status status = new Status(200, "OK");

    return ResponseEntity.ok(status);
  }
}
