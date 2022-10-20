package com.easybuy.service;

import com.easybuy.model.CartItem;
import com.easybuy.repository.CartItemRepository;
import com.easybuy.vo.CartItemVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    public List<CartItemVO> getAllCartItems(){
        List<CartItem> cartItems = cartItemRepository.findAll();
        List<CartItemVO> cartItemsVO = new ArrayList<>();
        for(CartItem cartItem : cartItems){
            CartItemVO cartItemVO =  new CartItemVO();
            cartItemVO.setCartItemId(cartItem.getCartItemId());
            cartItemVO.setProductId(cartItem.getProductId());
            cartItemVO.setQuantity(cartItem.getQuantity());
            cartItemVO.setTotalAmount(cartItem.getTotalAmount());
            cartItemVO.setCartId(cartItem.getCartId());
            cartItemsVO.add(cartItemVO);
        }
        return cartItemsVO;
    }
}
