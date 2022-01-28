package com.aplazo.interest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Edrd
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    
    @JsonProperty(value = "amount", required = true)
    private Double amount;
    @JsonProperty(value = "terms", required = true)
    private Integer terms;
    @JsonProperty(value = "rate", required = true)
    private Double rate;
    
}
