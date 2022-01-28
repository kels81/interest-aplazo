package com.aplazo.interest.controller;

import com.aplazo.interest.model.PurchaseRequest;
import com.aplazo.interest.model.InterestsResponse;
import com.aplazo.interest.service.InterestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edrd
 */
@RestController
@RequestMapping("/interest")
public class InterestController {
    
    @Autowired
    private InterestService interestService;
    
    @ApiOperation(value = "Registro de compra")
    @PostMapping("/crear-compra")
    public ResponseEntity<InterestsResponse> createPurchase(@RequestBody PurchaseRequest purchase) {
        
        InterestsResponse response = interestService.create(purchase);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
