package com.easybuy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "cart_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "cart_status")
    private Integer cartStatus;

    @Column(name = "user_id")
    private Integer userId;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy = "cart")
    private Set<Order> orders;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setCartStatus(Integer cartStatus) {
        this.cartStatus = cartStatus;
    }

    public Integer getCartStatus() {
        return cartStatus;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId + '\'' +
                "sessionId=" + sessionId + '\'' +
                "cartStatus=" + cartStatus + '\'' +
                "userId=" + userId + '\'' +
                '}';
    }
}
