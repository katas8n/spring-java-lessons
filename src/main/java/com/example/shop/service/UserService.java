package com.example.shop.service;

import com.example.shop.dto.UserDTO;
import com.example.shop.exceptions.NotFoundException;
import com.example.shop.model.User;
import com.example.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDTO> findAll() { return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).toList(); }
    public UserDTO getUserByName(String name) {
       User user = userRepository.findByName(name);

        System.out.println("Here we are");
       if(user == null) {
           throw new NotFoundException("User not found! Idiot!");
       }
       return  modelMapper.map(user, UserDTO.class);
    }

    public UserDTO createUser(User user) {
        User newUser = userRepository.save(user);

        return  modelMapper.map(newUser, UserDTO.class);
    }
}
