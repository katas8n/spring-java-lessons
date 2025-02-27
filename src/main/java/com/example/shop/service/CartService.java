package com.example.shop.service;

import com.example.shop.dto.CartDTO;
import com.example.shop.exceptions.NotFoundException;
import com.example.shop.model.Cart;
import com.example.shop.model.Product;
import com.example.shop.model.User;
import com.example.shop.repository.CartRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public CartDTO createCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));

        Cart cart = new Cart();
        cart.setUser(user);

        return modelMapper.map(cartRepository.save(cart), CartDTO.class);
    }

    public CartDTO getCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found"));

        return modelMapper.map(cart, CartDTO.class);
    }

    public CartDTO addProductToCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
        List<Product> products = cart.getProducts();

        products.add(product);
        cart.setProducts(products);

        return modelMapper.map(cartRepository.save(cart), CartDTO.class);
    }
}
