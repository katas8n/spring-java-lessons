package com.example.shop.service;

import com.example.shop.dto.ProductDTO;
import com.example.shop.dto.UserDTO;
import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductDTO> findAll() {
        return productRepository
                .findAll().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class)).toList();
    }

    public ProductDTO createProduct(Product product) {
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }

    public ProductDTO findProductById(Long id) {
        return modelMapper.map(productRepository.findById(id).orElse(null), ProductDTO.class);
    }

    public ProductDTO updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElse(null);
        product.setPrice(updatedProduct.getPrice());
        product.setName(updatedProduct.getName());
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
