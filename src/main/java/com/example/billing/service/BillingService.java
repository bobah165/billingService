package com.example.billing.service;

import com.example.billing.dto.Billing;
import com.example.billing.dto.Notification;
import com.example.billing.dto.Order;
import com.example.billing.repository.BillingRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingService {

  private final BillingRepository repository;
  private final NotificationProducer notificationProducer;

  @Transactional
  public void recalculate(Order order) {
    var bill = repository.findById(order.getUserId()).get();
    var orderSum = order.getPrice();
    var currentSum = bill.getCurrentUserSum();

    var message  = "Order not completed. No sum was debited from bill";
    if (currentSum > orderSum) {
      var newSumm = currentSum - orderSum;
      bill.setCurrentUserSum(newSumm);
      repository.save(bill);
      message = "Order completed successfully.";
    }

    var notification = Notification.builder()
      .id("1")
      .message(message)
      .build();

    notificationProducer.sendOrderEvent(notification);

  }

  @Transactional
  public Billing getCurrentBill(String billId) {
    return repository.findById(billId).get();
  }

  @Transactional
  public void save(Billing billing) {
    repository.save(billing);
  }
}
