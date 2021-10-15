package com.example.kafkaproducerstreams.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

  private Long id;

  private String name;

  private String type;

  private Double price;

  private Integer quantity;
}
