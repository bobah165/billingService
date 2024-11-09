package com.example.billing.service;

import com.example.billing.dto.Order;
import com.example.billing.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
  private final OrderRepository orderRepository;

  @Transactional
  public Order findOrder(String orderId) {
    return orderRepository.findById(orderId).get();
  }

  @Transactional
  public void save(Order order) {
    orderRepository.save(order);
  }
}
