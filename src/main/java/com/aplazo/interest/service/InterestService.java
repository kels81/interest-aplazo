package com.aplazo.interest.service;

import com.aplazo.interest.model.PurchaseRequest;
import com.aplazo.interest.model.InterestsResponse;

/**
 *
 * @author Edrd
 */
public interface InterestService {
    
    InterestsResponse create(PurchaseRequest request);
    
}
