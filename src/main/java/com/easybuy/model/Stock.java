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
    private Integer stockCount;

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

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStockCount() {
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
