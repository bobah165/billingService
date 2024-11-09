package com.example.billing.controller;

import com.example.billing.dto.Billing;
import com.example.billing.repository.BillingRepository;
import com.example.billing.repository.OrderRepository;
import com.example.billing.service.BillingService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/billing")
public class BillingController {

  private final BillingService service;


  @PostMapping("/save")
  public ResponseEntity createBill(@RequestBody Billing billing) {
    service.save(billing);
    return ResponseEntity.ok("Bill with sum = " + billing.getCurrentUserSum() + " was created");
  }

  @GetMapping("/{billId}")
  public ResponseEntity findBill(@PathVariable("billId") String billId) {
    var bill = service.getCurrentBill(billId);
    return ResponseEntity.ok("Current sum is " + bill.getCurrentUserSum());
  }
}
