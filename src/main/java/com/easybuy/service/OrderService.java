package com.easybuy.service;

import com.easybuy.model.Order;
import com.easybuy.repository.OrderRepository;
import com.easybuy.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<OrderVO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderVO> ordersVO = new ArrayList<>();
        for (Order order : orders) {
            OrderVO orderVO = new OrderVO();
            orderVO.setOrderId(order.getOrderId());
            orderVO.setCartId(order.getCartId());
            orderVO.setPaymentId(order.getPaymentId());
            orderVO.setOrderStatus(order.getOrderStatus());
            ordersVO.add(orderVO);
        }
        return ordersVO;
    }

    public Integer saveOrder(OrderVO orderVO){
        Order order = new Order();
        orderVO.setOrderId(order.getOrderId());
        orderVO.setCartId(order.getCartId());
        orderVO.setPaymentId(order.getPaymentId());
        orderVO.setOrderStatus(order.getOrderStatus());
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getOrderId();
    }
}
