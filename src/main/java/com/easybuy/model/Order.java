package com.easybuy.model;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "order_status")
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId + '\'' +
                "cartId=" + cartId + '\'' +
                "paymentId=" + paymentId + '\'' +
                "orderStatus=" + orderStatus + '\'' +
                '}';
    }
}
