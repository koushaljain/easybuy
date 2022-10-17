package com.easybuy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @OneToMany(mappedBy = "payment")
    private Set<Order> orders;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId + '\'' +
                "totalAmount=" + totalAmount + '\'' +
                "paymentStatus=" + paymentStatus + '\'' +
                '}';
    }
}
