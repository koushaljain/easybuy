package com.easybuy.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @Column(name = "cart_item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "cart_id")
    private Integer cartId;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false, insertable = false, updatable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false, insertable = false, updatable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartId() {
        return cartId;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId + '\'' +
                "productId=" + productId + '\'' +
                "quantity=" + quantity + '\'' +
                "totalAmount=" + totalAmount + '\'' +
                "cartId=" + cartId + '\'' +
                '}';
    }
}
