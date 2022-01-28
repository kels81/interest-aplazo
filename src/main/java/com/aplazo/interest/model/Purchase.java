package com.aplazo.interest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "purchase")
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @JsonProperty(value = "amount")
    private Double amount;
    @JsonProperty(value = "terms")
    private Integer terms;
    @JsonProperty(value = "rate")
    private Double rate;
    
}
