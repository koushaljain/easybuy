package com.easybuy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "stock_id")
    private Integer stockId;

    @ManyToOne
    @JoinColumn(name="stock_id", nullable=false)
    private Stock stock;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems;



    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockId() {
        return stockId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId + '\'' +
                "productName=" + productName + '\'' +
                "productPrice=" + productPrice + '\'' +
                "categoryId=" + categoryId + '\'' +
                "stockId=" + stockId + '\'' +
                '}';
    }
}
