package com.easybuy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "stock_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockId;

    @Column(name = "stock_count")
    private String stockCount;

    @OneToMany(mappedBy = "stock")
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockCount(String stockCount) {
        this.stockCount = stockCount;
    }

    public String getStockCount() {
        return stockCount;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId + '\'' +
                "stockCount=" + stockCount + '\'' +
                '}';
    }
}
