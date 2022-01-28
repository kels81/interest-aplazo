package com.aplazo.interest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Entity
@Table(name = "payment")
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Long id;
    @JsonProperty("payment_number")
    private Integer paymentNumber;
    @JsonProperty("amount")
    private Double amount;
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonProperty("payment_date")
    private Date paymentDate;
    @JsonProperty(access = Access.WRITE_ONLY)
    private Long purchaseID;
    
}
