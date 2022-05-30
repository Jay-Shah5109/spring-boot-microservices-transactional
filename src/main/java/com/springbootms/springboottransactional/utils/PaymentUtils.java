package com.springbootms.springboottransactional.utils;

import com.springbootms.springboottransactional.exception.InsufficientAmountFoundException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("Account1",10000.0);
        paymentMap.put("Account2",12000.0);
        paymentMap.put("Account3",5000.0);
        paymentMap.put("Account4",8000.0);
    }

    public static boolean validateCreditLimit(String accountNumber, double amountPaid) {

        if (amountPaid > paymentMap.get(accountNumber)) {
            throw new InsufficientAmountFoundException("Insufficient Funds..");
        } else
            return true;

    }
}
