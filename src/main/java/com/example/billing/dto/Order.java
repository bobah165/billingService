package com.example.billing.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "general", name = "order")
public class Order {
  @Id
  @Column(name = "id")
  private String orderId;
  @Column(name = "price")
  private Long price;
  @Column(name = "name")
  private String name;
  @Column(name = "user_id")
  private String userId;

}
