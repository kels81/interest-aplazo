package com.aplazo.interest.repository;

import com.aplazo.interest.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edrd
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
