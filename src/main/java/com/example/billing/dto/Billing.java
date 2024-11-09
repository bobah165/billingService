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
@Table(schema = "general", name = "billing")
public class Billing {
  @Id
  @Column(name = "id")
  private String userId;
  @Column(name = "sum")
  private Long currentUserSum;
}
