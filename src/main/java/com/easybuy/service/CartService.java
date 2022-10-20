package com.easybuy.service;

import com.easybuy.model.Cart;
import com.easybuy.repository.CartRepository;
import com.easybuy.vo.CartVO;
import com.easybuy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<CartVO> getAllCarts(){
        List<Cart> carts = cartRepository.findAll();
        List<CartVO> cartsVO = new ArrayList<>();
        for(Cart cart : carts){
            CartVO cartVO = new CartVO();
            cartVO.setCartId(cart.getCartId());
            cartVO.setSessionId(cart.getSessionId());
            cartVO.setCartStatus(cart.getCartStatus());
            cartVO.setUserId(cart.getUserId());
            cartsVO.add(cartVO);
        }
        return cartsVO;
    }
}
