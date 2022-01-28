/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplazo.interest.model;

import java.util.Collection;
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
public class InterestsResponse {

    private Collection<Payment> listPayments;

}
