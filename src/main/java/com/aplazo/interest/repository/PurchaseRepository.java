package com.aplazo.interest.repository;

import com.aplazo.interest.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edrd
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    
}
