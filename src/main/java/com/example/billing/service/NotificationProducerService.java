package com.example.billing.service;

import com.example.billing.dto.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducerService {

  @Value("${topic.send-notification}")
  private String sendClientTopic;

  private final KafkaTemplate<String , Object> kafkaTemplate;

  public void sendOrder(Notification notification) {
    kafkaTemplate.send(sendClientTopic, notification.getId(), notification);
  }
}
