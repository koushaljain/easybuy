package com.easybuy.service;

import com.easybuy.model.Payment;
import com.easybuy.repository.PaymentRepository;
import com.easybuy.vo.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public List<PaymentVO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentVO> paymentsVO = new ArrayList<>();
        for (Payment payment : payments) {
            PaymentVO paymentVO = new PaymentVO();
            paymentVO.setPaymentId(payment.getPaymentId());
            paymentVO.setTotalAmount(payment.getTotalAmount());
            paymentVO.setPaymentStatus(payment.getPaymentStatus());
            paymentsVO.add(paymentVO);
        }
        return paymentsVO;
    }

    public Integer savePayment(PaymentVO paymentVO){
        Payment payment = new Payment();
        paymentVO.setPaymentId(payment.getPaymentId());
        paymentVO.setTotalAmount(payment.getTotalAmount());
        paymentVO.setPaymentStatus(payment.getPaymentStatus());
        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment.getPaymentId();
    }
}
