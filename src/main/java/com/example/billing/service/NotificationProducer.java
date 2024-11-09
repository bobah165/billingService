package com.example.billing.service;

import com.example.billing.dto.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationProducer {
  private final NotificationProducerService notificationProducerService;


  public Notification sendOrderEvent(Notification notification) {
    notificationProducerService.sendOrder(notification);
    log.info("Send order from producer {}", notification);
    return notification;
  }

}
