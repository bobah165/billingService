package com.example.billing.service;

import com.example.billing.dto.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class OrderConsumerService {
  private static final String topicCreateOrder = "${topic.send-order}";
  private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";
  private final OrderService orderService;
  private final BillingService billingService;

  @Transactional
  @KafkaListener(topics = topicCreateOrder, groupId = kafkaConsumerGroupId, properties = {"spring.json.value.default.type=com.example.billing.dto.Order"})
  public Order createOrder(Order orderEvent) {
    log.info("Message consumed {}", orderEvent);
    orderService.save(orderEvent);
    billingService.recalculate(orderEvent);
    return orderEvent;
  }
}
