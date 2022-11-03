package com.easybuy.controller;

import com.easybuy.service.InventoryService;
import com.easybuy.service.ProductService;
import com.easybuy.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {
    //product save
    //post method add vo
    @Autowired
    InventoryService inventoryService;

    @PostMapping("/Product")
    public ResponseEntity<Integer> addInventory(@RequestBody InventoryAddVO inventoryAddVO) {
        Integer productId  = inventoryService.addInventory(inventoryAddVO);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
}
