package com.aplazo.interest.service.impl;

import com.aplazo.interest.model.PurchaseRequest;
import com.aplazo.interest.model.InterestsResponse;
import com.aplazo.interest.model.Payment;
import com.aplazo.interest.model.Purchase;
import javax.transaction.Transactional;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aplazo.interest.repository.PaymentRepository;
import com.aplazo.interest.repository.PurchaseRepository;
import com.aplazo.interest.service.InterestService;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.IntStream;

/**
 *
 * @author Edrd
 */
@Service
@Transactional
@Log4j
public class InterestServiceImpl implements InterestService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public InterestsResponse create(PurchaseRequest request) {

        Purchase purchase = new Purchase();
        purchase.setAmount(request.getAmount());
        purchase.setRate(request.getRate());
        purchase.setTerms(request.getTerms());

        purchaseRepository.save(purchase);

        return new InterestsResponse(calculatePaymentTermsInterest(purchase));
    }

    private Collection<Payment> calculatePaymentTermsInterest(Purchase purchase) {

        var interest = (purchase.getAmount() * purchase.getRate() * purchase.getTerms()) / 100;
        var totalWithInterest = purchase.getAmount() + interest;
        var paymentTerms = totalWithInterest / purchase.getTerms();

        Collection<Payment> lstPayment = new ArrayList<>();

        IntStream.range(0, purchase.getTerms()).forEach(i -> {
            i++;
            Payment payment = new Payment();
            payment.setAmount(getDoubleTwoDecimals(paymentTerms));
            payment.setPaymentNumber(i);
            payment.setPaymentDate(getPaymentDate(i));
            payment.setPurchaseID(purchase.getId());
            lstPayment.add(payment);
        });

        paymentRepository.saveAll(lstPayment);

        return lstPayment;
    }

    private Date getPaymentDate(int termNumber) {
        int plusDays = 7 * termNumber;

        LocalDate date = LocalDate.now();
        date = date.plusDays(plusDays);

        return Date.from(date
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    private double getDoubleTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
