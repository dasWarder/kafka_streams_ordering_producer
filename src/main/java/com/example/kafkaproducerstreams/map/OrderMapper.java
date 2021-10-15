package com.example.kafkaproducerstreams.map;

import com.example.kafkaproducerstreams.dto.OrderRequest;
import com.example.kafkaproducerstreams.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderMapper {

  public Order orderRequestToOrder(OrderRequest request) {

    log.info("Map an orderRequest object to an order object");

    Order order =
        Order.builder()
            .id(request.getId())
            .name(request.getName())
            .type(request.getType())
            .price(request.getPrice())
            .quantity(request.getQuantity())
            .build();

    return order;
  }
}
