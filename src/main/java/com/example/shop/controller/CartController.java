package com.example.shop.controller;

import com.example.shop.dto.CartDTO;
import com.example.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    // for creating a cart, we need to pass userId, but I don't like URL for this
    @PostMapping("/{userId}")
    public CartDTO createCart(@PathVariable Long userId) {
        return cartService.createCart(userId);
    }

    @GetMapping("/{cartId}")
    public CartDTO getCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId);
    }

    @PostMapping("/{cartId}/add-product")
    public CartDTO addProductToCart(@PathVariable Long cartId, @RequestParam("productId") Long productId) {
        return cartService.addProductToCart(cartId, productId);
    }
}
