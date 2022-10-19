package com.easybuy.service;

import com.easybuy.model.Stock;
import com.easybuy.repository.StockRepository;
import com.easybuy.vo.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<StockVO> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        List<StockVO> stocksVO = new ArrayList<>();
        for (Stock stock : stocks) {
            StockVO stockVO = new StockVO();
            stockVO.setStockId(stock.getStockId());
            stockVO.setStockCount(stock.getStockCount());
            stocksVO.add(stockVO);
        }
        return stocksVO;
    }

    public Integer saveStock(StockVO stockVO){
        Stock stock = new Stock();
        stock.setStockCount(stockVO.getStockCount());
        Stock savedStock = stockRepository.save(stock);
        return savedStock.getStockId();
    }
}
