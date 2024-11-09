package com.example.billing.repository;

import com.example.billing.dto.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, String> {
}
